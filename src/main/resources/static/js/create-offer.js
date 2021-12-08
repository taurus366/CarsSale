let localUrl = 'http://localhost:8080';
let wanUrl = 'http://77.71.76.17:8080';

let vehicleType = document.querySelector('.vehicle-type');

fetch('http://localhost:8080/users/category',{method:'GET'})
    .then(response => response.json())
    .then(data => {
        Array.from(data)
            .forEach(category => {
                let newOptionElement = document.createElement('option');
                newOptionElement.textContent = category.category;
                newOptionElement.setAttribute("value",category.id);
                vehicleType.appendChild(newOptionElement);
            })
    })


document.querySelector('.extras-btn').addEventListener('click', () => {
   let ulArticle = document.querySelector('.extras-article-ul');

    if (ulArticle.style.display === "block") {
        ulArticle.style.display = 'none';
    } else {
        ulArticle.style.display = "block";
    }
});

function doFetchForBrand(id) {
    brandSelect.removeAttribute('disabled');
    let childrenOfBrand = brandSelect.children;

    Array.from(childrenOfBrand)
        .forEach(value => brandSelect.removeChild(value));

    fetch('http://localhost:8080/users/brand/'+id,{method:'GET'})
        .then(response => response.json())
        .then(data => {
            Array.from(data)
                .forEach(brand => {
                    let newBrandOptionEl = document.createElement('option');
                    newBrandOptionEl.textContent = brand.brandName;
                    newBrandOptionEl.setAttribute("value", brand.id);
                    brandSelect.appendChild(newBrandOptionEl);
                })
        })

    console.log(id)
}

let brandSelect = document.querySelector('#vehicleBrand');
let modelSelect = document.querySelector('#vehicleModel');

document.querySelector('.vehicle-type').addEventListener('change',(ev) => {
    let id = ev.target.value;
    let icon;


    if (id === 'choose') {
        icon = '.fa-th-list'

        brandSelect.setAttribute("disabled","disabled");
        modelSelect.setAttribute("disabled","disabled");
    }else {

        // modelSelect.removeAttribute('disabled');
        doFetchForBrand(id);
    }
    if (id === '2'){
        icon = '.fa-bus'
    }
    if (id === "1") {
        icon = '.fa-car-side'
    }
    if (id === "3") {
        icon = '.fa-motorcycle'
    }
    if (id === "4") {
        icon = '.fa-truck'
    }
    // if (vehicleTypeText === "Boat") {
    //     icon = '.fa-ship'
    // }
    // console.log(vehicleTypeText)

    document.querySelectorAll('.ico')
        .forEach(icon => {
            icon.style.display = 'none';
        });

    document.querySelector(icon).style.display = 'block';
});

