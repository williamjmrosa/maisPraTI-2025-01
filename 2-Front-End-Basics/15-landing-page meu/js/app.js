document.addEventListener('DOMContentLoaded', () => {
    const swiper = new swiper('.swiper', {
        direction: 'horizontal',
        loop: true,
        navigation:{
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev'
        }
    })
})