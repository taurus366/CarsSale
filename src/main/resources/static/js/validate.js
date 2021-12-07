let isValid = document.querySelectorAll('.is-invalid');
let invalidFeedBack = document.querySelectorAll('.invalid-feedback');
console.log(isValid);
Array.from(invalidFeedBack)
    .forEach(invalidF => {
        invalidF.classList.contains('hidden');
    });

Array.from(isValid)
    .forEach(child => {
        let children = child.parentElement.children[3];
        console.log(children);
        children.classList.remove('hidden');

    });