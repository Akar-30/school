// This is a simple JavaScript program that prints "Hello, World!" to the console

function greet() {
    console.log("Hello, World!");
}
document.addEventListener('DOMContentLoaded', (event) => {
    const button = document.createElement('button');
    button.textContent = 'Click me';
    button.addEventListener('click', greet);
    document.body.appendChild(button);
});
greet();

var x = 10;
console.log(x++);