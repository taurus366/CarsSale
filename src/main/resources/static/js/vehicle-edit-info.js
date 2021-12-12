let btn2 = document.querySelectorAll('.change-pictures-btn-a');
let img2 = document.querySelector('.img-main-edit');
btn2
    .forEach(btn => {
        btn.addEventListener('click',(ev) => {
            ev.preventDefault();

            btn2
                .forEach(btn => btn.classList.remove('active'));
            console.log(btn)

            if (!btn.classList.contains('active')){
                btn.classList.add('active');
                img2.setAttribute("src",btn.getAttributeNode("href").value);
            }

        })
    })