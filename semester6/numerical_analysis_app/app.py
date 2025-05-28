 
from flask import Flask, render_template, request, jsonify
import numpy as np
import math

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

# Least Squares and Curve Fitting
# Linear Regression
@app.route('/linear_regression', methods=['GET', 'POST'])
def linear_regression():
    if request.method == 'POST':
        try:
            x_values = list(map(float, request.form['x_values'].split(',')))
            y_values = list(map(float, request.form['y_values'].split(',')))
            
            # Linear regression (y = ax + b)
            A = np.vstack([x_values, np.ones(len(x_values))]).T
            a, b = np.linalg.lstsq(A, y_values, rcond=None)[0]
            
            # Generate points for plotting
            x_fit = np.linspace(min(x_values), max(x_values), 100)
            y_fit = a * x_fit + b
            
            return render_template('linear_regression.html',
                                 slope=a,
                                 intercept=b,
                                 x_values=x_values,
                                 y_values=y_values,
                                 x_fit=x_fit.tolist(),
                                 y_fit=y_fit.tolist(),
                                 show_result=True)
                
        except Exception as e:
            return render_template('linear_regression.html', error=str(e))
    return render_template('linear_regression.html')

# Polynomial Fitting
@app.route('/polynomial_fit', methods=['GET', 'POST'])
def polynomial_fit():
    if request.method == 'POST':
        try:
            x_values = list(map(float, request.form['x_values'].split(',')))
            y_values = list(map(float, request.form['y_values'].split(',')))
            degree = int(request.form['degree'])
            
            # Polynomial fitting
            coeffs = np.polyfit(x_values, y_values, degree)
            polynomial = np.poly1d(coeffs)
            
            # Generate points for plotting
            x_fit = np.linspace(min(x_values), max(x_values), 100)
            y_fit = polynomial(x_fit)
            
            return render_template('polynomial_fit.html',
                                 polynomial=str(polynomial),
                                 coeffs=coeffs,
                                 x_values=x_values,
                                 y_values=y_values,
                                 x_fit=x_fit.tolist(),
                                 y_fit=y_fit.tolist(),
                                 show_result=True)
                
        except Exception as e:
            return render_template('polynomial_fit.html', error=str(e))
    return render_template('polynomial_fit.html')

# Newton Gregory Forward
@app.route('/newton_gregory', methods=['GET', 'POST'])
def newton_gregory():
    if request.method == 'POST':
        try:
            x_input = request.form['x_values']
            y_input = request.form['y_values']
            x_values = list(map(float, x_input.split(',')))
            y_values = list(map(float, y_input.split(',')))
            x_target = float(request.form['x_target'])
            
            n = len(x_values)
            if n != len(y_values):
                raise ValueError("Number of x and y values must be equal")
            
            h = x_values[1] - x_values[0]
            u = (x_target - x_values[0]) / h
            
            # Create and populate forward difference table
            diff_table = [[0] * n for _ in range(n)]
            for i in range(n):
                diff_table[i][0] = y_values[i]
            
            for j in range(1, n):
                for i in range(n - j):
                    diff_table[i][j] = diff_table[i+1][j-1] - diff_table[i][j-1]
            
            # Calculate interpolation with steps
            result = diff_table[0][0]
            steps = [f"Initial value: y0 = {result}"]
            
            for i in range(1, n):
                term = 1
                for j in range(i):
                    term *= (u - j)
                term /= math.factorial(i)
                term *= diff_table[0][i]
                result += term
                steps.append(
                    f"Add term {i}: [u(u-1)...(u-{i-1})/{i}!] * Δ^{i}y0 = " +
                    f"[{term * math.factorial(i)/diff_table[0][i]}]/{i}! * {diff_table[0][i]} = {term}"
                )
            
            return render_template('newton_gregory.html', 
                                 result=result,
                                 x_target=x_target,
                                 x_values=x_values,
                                 y_values=y_values,
                                 diff_table=diff_table,
                                 steps=steps,
                                 u=u,
                                 h=h,
                                 show_result=True)
        except Exception as e:
            return render_template('newton_gregory.html', error=str(e))
    return render_template('newton_gregory.html')

# False Position Method
@app.route('/false_position', methods=['GET', 'POST'])
def false_position():
    if request.method == 'POST':
        try:
            f_expr = request.form['function']
            a = float(request.form['a'])
            b = float(request.form['b'])
            tolerance = float(request.form['tolerance'])
            max_iter = int(request.form['max_iter'])
            
            def f(x):
                return eval(f_expr)
            
            if f(a) * f(b) >= 0:
                raise ValueError("Function must have opposite signs at endpoints")
            
            iterations = []
            for i in range(max_iter):
                fa = f(a)
                fb = f(b)
                c = (a * fb - b * fa) / (fb - fa)
                fc = f(c)
                abs_diff = abs(b - a)
                
                iterations.append({
                    'iteration': i+1,
                    'a': a,
                    'b': b,
                    'c': c,
                    'f(a)': fa,
                    'f(b)': fb,
                    'f(c)': fc,
                    'abs_diff': abs_diff
                })
                
                if abs(fc) < tolerance:
                    break
                    
                if fa * fc < 0:
                    b = c
                else:
                    a = c
            
            return render_template('false_position.html',
                                 root=c,
                                 iterations=iterations,
                                 show_result=True)
        except Exception as e:
            return render_template('false_position.html', error=str(e))
    return render_template('false_position.html')

# Lagrange Interpolation
@app.route('/lagrange', methods=['GET', 'POST'])
def lagrange():
    if request.method == 'POST':
        try:
            x_values = list(map(float, request.form['x_values'].split(',')))
            y_values = list(map(float, request.form['y_values'].split(',')))
            x_target = float(request.form['x_target'])
            
            n = len(x_values)
            result = 0.0
            
            for i in range(n):
                term = y_values[i]
                for j in range(n):
                    if i != j:
                        term *= (x_target - x_values[j]) / (x_values[i] - x_values[j])
                result += term
                
            return render_template('lagrange.html',
                                 result=result,
                                 x_target=x_target,
                                 show_result=True)
        except Exception as e:
            return render_template('lagrange.html', error=str(e))
    return render_template('lagrange.html')

# Forward Difference Table
@app.route('/difference_table', methods=['GET', 'POST'])
def difference_table():
    if request.method == 'POST':
        try:
            y_values = list(map(float, request.form['y_values'].split(',')))
            
            n = len(y_values)
            diff_table = [y_values.copy()]
            for i in range(1, n):
                diff_table.append([])
                for j in range(n - i):
                    diff_table[i].append(diff_table[i-1][j+1] - diff_table[i-1][j])
            
            return render_template('difference_table.html',
                                 diff_table=diff_table,
                                 show_result=True)
        except Exception as e:
            return render_template('difference_table.html', error=str(e))
    return render_template('difference_table.html')

# Secant Method
@app.route('/secant', methods=['GET', 'POST'])
def secant():
    if request.method == 'POST':
        try:
            f_expr = request.form['function']
            x0 = float(request.form['x0'])
            x1 = float(request.form['x1'])
            tolerance = float(request.form['tolerance'])
            max_iter = int(request.form['max_iter'])
            
            def f(x):
                return eval(f_expr, {"__builtins__": None, "x": x, "sin": math.sin, "cos": math.cos, "tan": math.tan, "e": math.e, "exp": math.exp, "log": math.log, "sqrt": math.sqrt, "pi": math.pi})
            
            iterations = []
            for i in range(max_iter):
                fx0 = f(x0)
                fx1 = f(x1)
                
                if abs(fx1) < tolerance:
                    break
                    
                x2 = x1 - fx1 * (x1 - x0) / (fx1 - fx0)
                iterations.append({
                    'iteration': i+1,
                    'x0': x0,
                    'x1': x1,
                    'x2': x2,
                    'f(x0)': fx0,
                    'f(x1)': fx1
                })
                
                x0, x1 = x1, x2
            
            return render_template('secant.html',
                                 root=x1,
                                 iterations=iterations,
                                 show_result=True)
        except Exception as e:
            return render_template('secant.html', error=str(e))
    return render_template('secant.html')

# Newton-Raphson Method
@app.route('/newton_raphson', methods=['GET', 'POST'])
def newton_raphson():
    if request.method == 'POST':
        try:
            f_expr = request.form['function']
            df_expr = request.form['derivative']
            x0 = request.form['x0']
            x0 = eval(x0, {"__builtins__": None, "sin": math.sin, "cos": math.cos, "tan": math.tan, "e": math.e, "exp": math.exp, "log": math.log, "sqrt": math.sqrt, "pi": math.pi})
            tolerance = float(request.form['tolerance'])
            max_iter = int(request.form['max_iter'])
            
            def f(x):
                return eval(f_expr, {"__builtins__": None, "x": x, "sin": math.sin, "cos": math.cos, "tan": math.tan, "e": math.e, "exp": math.exp, "log": math.log, "sqrt": math.sqrt, "pi": math.pi})
            
            def df(x):
                return eval(df_expr, {"__builtins__": None, "x": x, "sin": math.sin, "cos": math.cos, "tan": math.tan, "e": math.e, "exp": math.exp, "log": math.log, "sqrt": math.sqrt, "pi": math.pi})
            
            iterations = []
            for i in range(max_iter):
                fx = f(x0)
                dfx = df(x0)
                
                if abs(fx) < tolerance:
                    break
                    
                x1 = x0 - fx / dfx
                iterations.append({
                    'iteration': i+1,
                    'x': x0,
                    'f(x)': fx,
                    'f\'(x)': dfx,
                    'x_next': x1
                })
                
                x0 = x1
            
            return render_template('newton_raphson.html',
                                 root=x0,
                                 iterations=iterations,
                                 show_result=True)
        except Exception as e:
            return render_template('newton_raphson.html', error=str(e))
    return render_template('newton_raphson.html')

# Bisection Method
@app.route('/bisection', methods=['GET', 'POST'])
def bisection():
    if request.method == 'POST':
        try:
            f_expr = request.form['function']
            a = float(request.form['a'])
            b = float(request.form['b'])
            tolerance = float(request.form['tolerance'])
            max_iter = int(request.form['max_iter'])
            
            # Allow math functions in eval
            def f(x):
                return eval(f_expr, {"__builtins__": None, "x": x, "sin": math.sin, "cos": math.cos, "tan": math.tan, "e": math.e, "exp": math.exp, "log": math.log, "sqrt": math.sqrt, "pi": math.pi})
            
            if f(a) * f(b) >= 0:
                raise ValueError("Function must have opposite signs at endpoints")
            
            iterations = []
            for i in range(max_iter):
                c = (a + b) / 2
                fc = f(c)
                abs_diff = abs(b - c)
                
                iterations.append({
                    'iteration': i+1,
                    'a': a,
                    'b': b,
                    'c': c,
                    'f(a)': f(a),
                    'f(b)': f(b),
                    'f(c)': fc,
                    'abs_diff': abs_diff
                })
                
                if abs(fc) < tolerance:
                    break
                    
                if f(a) * fc < 0:
                    b = c
                else:
                    a = c
            
            return render_template('bisection.html',
                                 root=c,
                                 iterations=iterations,
                                 show_result=True)
        except Exception as e:
            return render_template('bisection.html', error=str(e))
    return render_template('bisection.html')

if __name__ == '__main__':
    app.run(debug=True)