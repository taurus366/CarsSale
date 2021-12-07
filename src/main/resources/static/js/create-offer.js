document.querySelector('.extras-btn').addEventListener('click', () => {
   let ulArticle = document.querySelector('.extras-article-ul');

    if (ulArticle.style.display === "block") {
        ulArticle.style.display = 'none';
    } else {
        ulArticle.style.display = "block";
    }
});

document.querySelector('.vehicle-type').addEventListener('change',(ev) => {
    let vehicleTypeText = ev.target.value;
    let icon;

    if (vehicleTypeText === 'Bus'){
        icon = '.fa-bus'
    }
    if (vehicleTypeText === "Car") {
        icon = '.fa-car-side'
    }
    if (vehicleTypeText === "Motorcycle") {
        icon = '.fa-motorcycle'
    }
    if (vehicleTypeText === "Truck") {
        icon = '.fa-truck'
    }
    if (vehicleTypeText === "Boat") {
        icon = '.fa-ship'
    }

    document.querySelectorAll('.ico')
        .forEach(icon => {
            icon.style.display = 'none';
        });

   document.querySelector(icon).style.display = 'block';
});