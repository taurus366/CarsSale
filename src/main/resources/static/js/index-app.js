let dropBtnAdmin = document.querySelector('.drop-btn.admin');
let activeBtns = document.querySelectorAll('.btn-link');
let dropBtnUser = document.querySelector('.drop-btn.user');

console.log(activeBtns);


if (dropBtnAdmin !== null) {
    dropBtnAdmin.addEventListener('click', () => {
        let ul = document.querySelector('.dropdown-menu.admin');
        console.log(ul)
        if (ul.style.display === "block") {
            ul.style.display = 'none';
        } else {
            ul.style.display = "block";
        }
    });
}



activeBtns
    .forEach(btn => {
        btn.addEventListener('click',(ev) => {

           cleanActiveBtns(btn);

          if (!btn.classList.contains('active')){
              btn.classList.add('active');
          }
        })
    })



// console.log(activeBtns);


// Here i read url for active link buttons in NAV (HEADER)
let currUrl = window.location.href;
let splitText = currUrl.split("/");
let typeName = splitText[splitText.length-1];

activeBtns
    .forEach(btn2 => {
       cleanActiveBtns(btn2);

        if (btn2.innerText.trim().toLowerCase() === typeName.toLowerCase()) {
            btn2.classList.add('active');
        }
    })

function cleanActiveBtns(btn) {
    activeBtns
        .forEach(btns2 => btn.classList.remove('active'));
}


if (dropBtnUser !== null) {
    dropBtnUser.addEventListener('click', () => {
        let ul = document.querySelector('.dropdown-menu.user');
        console.log(ul)
        if (ul.style.display === "block") {
            ul.style.display = 'none';
        } else {
            ul.style.display = "block";
        }
    });
}

// let urlText = currUrl.match('/\\w+.html').toString();
// console.log(urlText.substr(1,urlText.length-6));