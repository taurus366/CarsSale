let localUrl = 'http://localhost:8080';
let wanUrl = 'http://77.71.76.17:8080';


let vehicleType = document.querySelector('.vehicle-type');

let brandSelect = document.querySelector('#vehicleBrand');
let modelSelect = document.querySelector('#vehicleModel');

let transmissionSelect = document.querySelector('#transmission');
let coupeTypeSelect = document.querySelector('#vehicleCoupe');
let vehicleYearSelect = document.querySelector('#year');
let fuelTypeSelect = document.querySelector("#fuelType");

let disableAndEnable = {
    disableModel() {
        modelSelect.setAttribute("disabled", "disabled")
    },
    enableModel() {
        modelSelect.removeAttribute('disabled');
    },
    disableBrand() {
        brandSelect.setAttribute("disabled", "disabled");
    },
    enableBrand() {
        brandSelect.removeAttribute('disabled');
    },
    disableTransmission() {
        transmissionSelect.setAttribute("disabled", "disabled");
    },
    enableTransmission() {
        transmissionSelect.removeAttribute("disabled");
    },
    disableCoupeType() {
        coupeTypeSelect.setAttribute("disabled", "disabled");
    },
    enableCoupeType() {
        coupeTypeSelect.removeAttribute("disabled");
    },
    disableYear() {
        vehicleYearSelect.setAttribute("disabled", "disabled");
    },
    enableYear() {
        vehicleYearSelect.removeAttribute("disabled");
    },
    disableFuelType() {
        fuelTypeSelect.setAttribute("disabled", "disabled");
    },
    enableFuelType() {
        fuelTypeSelect.removeAttribute("disabled");
    }
}

function removeChild(childNote,select) {
    Array.from(childNote)
        .forEach(value => {
            if (value.value !== 'choose'){
                select.removeChild(value);
            }
        })
}
let lastModel;
let lastModelEach;
doFetchCategory();


document.querySelector('.extras-btn').addEventListener('click', () => {
    let ulArticle = document.querySelector('.extras-article-ul');

    if (ulArticle.style.display === "block") {
        ulArticle.style.display = 'none';
    } else {
        ulArticle.style.display = "block";
    }
});




modelSelect.addEventListener("change", (ev) => {
//TODO
    let id = ev.target.value;
    if (id !== 'choose') {
        Array.from(lastModel)
            .forEach(model => {
                if (model.id === parseInt(id)){
                    lastModelEach = model;
                }
            });

        populateFuelType(lastModelEach.fuelType,fuelTypeSelect);
        populateTransmission(lastModelEach.transmission,transmissionSelect);
        populateYear(lastModelEach.vehicleYear,vehicleYearSelect);
        populateCoupeType(lastModelEach.vehicleCoupe,coupeTypeSelect);

        disableAndEnable.enableCoupeType();

    } else {
        disableAndEnable.disableTransmission();
        disableAndEnable.disableYear();
        disableAndEnable.disableCoupeType();
        disableAndEnable.disableFuelType();
    }

});

function populateFuelType(fuelType,select) {

    let children = select.children;
    removeChild(children,select);

    disableAndEnable.enableFuelType();

    Array.from(fuelType)
        .forEach(fuel => {
            let elFuel = document.createElement("option");
            elFuel.textContent = fuel.name;
            elFuel.value = fuel.name;
            select.appendChild(elFuel);
        });

}
function populateTransmission(transmission, select) {
    let children = select.children;
    removeChild(children,select);
    disableAndEnable.enableTransmission();

    Array.from(transmission)
        .forEach(transmission => {
            let elTransmission2 = document.createElement("option");
            elTransmission2.textContent = transmission.transmission;
            elTransmission2.value = transmission.transmission;
            select.appendChild(elTransmission2);
        });

}

function populateYear(vehicleYear, vehicleYearSelect) {
    let children = vehicleYearSelect.children;
    removeChild(children,vehicleYearSelect);
    disableAndEnable.enableYear();

    Array.from(vehicleYear)
        .forEach(year => {
            let elYear = document.createElement("option");
            elYear.textContent = year.vehicleYear;
            elYear.value = year.vehicleYear;
            vehicleYearSelect.appendChild(elYear);
        })
}

function populateCoupeType(vehicleCoupe, coupeTypeSelect) {
    let children = coupeTypeSelect.children;
    removeChild(children,coupeTypeSelect);
    disableAndEnable.enableYear();

    Array.from(vehicleCoupe)
        .forEach(coupe => {
            let elCoupe = document.createElement("option");
            elCoupe.textContent = coupe.vehicleCoupe;
            elCoupe.value = coupe.vehicleCoupe;
            coupeTypeSelect.appendChild(elCoupe);
        })
}

brandSelect.addEventListener('change', (ev) => {
    let id = ev.target.value;
    if (id !== 'choose') {

        doFetchForModel(id);
    } else {
        disableAndEnable.disableModel();
    }
});

document.querySelector('.vehicle-type').addEventListener('change', (ev) => {
    let id = ev.target.value;
    let icon;


    if (id === 'choose') {
        icon = '.fa-th-list'

        disableAndEnable.disableBrand();
        disableAndEnable.disableModel();
        disableAndEnable.disableTransmission();
        disableAndEnable.disableCoupeType();
        disableAndEnable.disableYear();
        disableAndEnable.disableFuelType();
    } else {
        doFetchForBrand(id);


    }
    if (id === '2') {
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

    document.querySelectorAll('.ico')
        .forEach(icon => {
            icon.style.display = 'none';
        });

    document.querySelector(icon).style.display = 'block';
});

function doFetchCategory() {
    fetch('http://localhost:8080/users/category', {method: 'GET'})
        .then(response => response.json())
        .then(data => {
            Array.from(data)
                .forEach(category => {
                    let newOptionElement = document.createElement('option');
                    newOptionElement.textContent = category.category;
                    newOptionElement.setAttribute("value", category.id);
                    vehicleType.appendChild(newOptionElement);
                })
        })
}

function doFetchForModel(id) {
    disableAndEnable.enableModel();

    fetch('http://localhost:8080/users/model/' + id, {method: 'GET'})
        .then(response => response.json())
        .then(models => {
            let children = modelSelect.children;
            removeChild(children,modelSelect);
            lastModel = models;
            Array.from(models)
                .forEach(model => {
                    let elModel = document.createElement("option");
                    elModel.textContent = model.modelName;
                    elModel.setAttribute("value", model.id);

                    modelSelect.appendChild(elModel);
                })
        })

}

function doFetchForBrand(id) {
    disableAndEnable.enableBrand();
    let childrenOfBrand = brandSelect.children;

    removeChild(childrenOfBrand,brandSelect);

    fetch('http://localhost:8080/users/brand/' + id, {method: 'GET'})
        .then(response => response.json())
        .then(data => {
            Array.from(data)
                .forEach(brand => {
                    let newBrandOptionEl = document.createElement('option');
                    newBrandOptionEl.textContent = brand.brandName;
                    newBrandOptionEl.setAttribute("value", brand.id);
                    brandSelect.appendChild(newBrandOptionEl);
                })
        });


}