let region = document.querySelector('#region');
let cityVillage = document.querySelector('#cityVillage');

fetch('http://localhost:8080/users/region',{method:'GET'})
    .then(response => response.json())
    .then(data => {
      data
          Array.from(data)
              .forEach(datam => {
                  let htmlOptionElement = document.createElement('option');
                  htmlOptionElement.textContent = datam.regionName;
                  htmlOptionElement.setAttribute("value",datam.id);
                  region.appendChild(htmlOptionElement);
              })
    });

region
    .addEventListener('change',(event) => {
        let regionId = event.target.value;
     if (event.target.value !== '') {
         cityVillage.removeAttribute('disabled');
         fetchForCityVillage(regionId);
     }else {
         cityVillage.setAttribute("disabled","disabled");
     }
    })

function fetchForCityVillage(id) {
    fetch('http://localhost:8080/users/cityVillage/'+id,{
        method:'GET'
    })
        .then(response => response.json())
        .then(data => {
            let children = cityVillage.childNodes;
            // clean city/village list before populate it !
            Array.from(children)
                .forEach(value => cityVillage.removeChild(value))
            // populate city/village
            Array.from(data)
                .forEach(city => {
                    let htmlOptionElement = document.createElement('option');
                    htmlOptionElement.textContent = city.cityVillageName;
                    htmlOptionElement.setAttribute("value",city.id);
                    cityVillage.appendChild(htmlOptionElement);
                })
        });
}