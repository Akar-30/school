document.addEventListener('DOMContentLoaded', function () {
    // Mobile menu toggle
    const mobileMenuToggle = document.createElement('div');
    mobileMenuToggle.className = 'mobile-menu-toggle';
    mobileMenuToggle.innerHTML = '☰ Menu';
    document.querySelector('header').prepend(mobileMenuToggle);

    const navbar = document.querySelector('.navbar');
    mobileMenuToggle.addEventListener('click', function () {
        navbar.style.display = navbar.style.display === 'flex' ? 'none' : 'flex';
    });

    // Close dropdowns when clicking elsewhere
    document.addEventListener('click', function (e) {
        if (!e.target.closest('.dropdown')) {
            document.querySelectorAll('.dropdown-menu').forEach(menu => {
                menu.style.display = 'none';
            });
        }
    });

    // Handle window resize
    function handleResize() {
        if (window.innerWidth > 768) {
            navbar.style.display = 'flex';
        } else {
            navbar.style.display = 'none';
        }
    }

    window.addEventListener('resize', handleResize);
    handleResize();

    // Plotly initialization if needed
    if (document.querySelector('#chart-container')) {
        const script = document.createElement('script');
        script.src = 'https://cdn.plot.ly/plotly-latest.min.js';
        document.head.appendChild(script);
    }
});