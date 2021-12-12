let btns = document.querySelectorAll('.change-pictures-btn-a');
let img = document.querySelector('.img-main');
btns
    .forEach(btn => {
        btn.addEventListener('click',(ev) => {
            ev.preventDefault();

            btns
                .forEach(btn => btn.classList.remove('active'));

            if (!btn.classList.contains('active')){
                btn.classList.add('active');
                img.setAttribute("src",btn.getAttributeNode("href").value);
            }

        })
    })