let btns = document.querySelectorAll('.change-pictures-btn-a');

btns
    .forEach(btn => {
        btn.addEventListener('click',() => {

            btns
                .forEach(btn => btn.classList.remove('active'));
        console.log(btn)

            if (!btn.classList.contains('active')){
                btn.classList.add('active');
            }

        })
    })

// console.log(btns)