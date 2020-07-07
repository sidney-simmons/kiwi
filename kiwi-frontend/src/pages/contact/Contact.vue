<template>
    <div>
        <NavBar currentPage="contact"/>
        <main role="main" class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <h2 class="section-title">Reach Out!</h2>
                </div>
                <div class="col-12 col-sm-7 col-md-7 col-lg-7 col-xl-9 margin-bottom">
                    <ul class="list-group">
                        <li class="list-group-item contact-option-item"><img src="@/assets/images/baseline_email_black_18dp.png" class="contact-option-image" />
                            <div class="contact-option-text">
                                <a href="mailto:sas.simm@gmail.com" class="js-contact-link">sas.simm@gmail.com</a>
                            </div></li>
                        <li class="list-group-item contact-option-item"><img src="@/assets/images/baseline_call_black_18dp.png" class="contact-option-image" />
                            <div class="contact-option-text">
                                <a href="tel:+256-797-4892" class="js-contact-link">(256) 797-4892</a>
                            </div></li>
                        <li class="list-group-item contact-option-item"><img src="@/assets/images/baseline_place_black_18dp.png" class="contact-option-image" />
                            <div class="contact-option-text">
                                Fort Collins, Colorado
                            </div></li>
                        <li class="list-group-item contact-option-item"><img src="@/assets/images/baseline_code_black_18dp.png" class="contact-option-image" />
                            <div class="contact-option-text">
                                <a href="https://github.com/sidney-simmons" class="js-contact-link">https://github.com/sidney-simmons</a>
                            </div></li>
                        <li class="list-group-item contact-option-item"><img src="@/assets/images/baseline_work_black_18dp.png" class="contact-option-image" />
                            <div class="contact-option-text">
                                <a href="https://www.linkedin.com/in/sidney-simmons-446b5b59" class="js-contact-link">https://www.linkedin.com/in/sidney-simmons-446b5b59</a>
                            </div></li>
                    </ul>
                </div>
                <div class="col-12 col-sm-5 col-md-5 col-lg-5 col-xl-3 margin-bottom">
                    <img src="https://avatars3.githubusercontent.com/u/22179726?v=4" class="github-profile-pic" />
                </div>
            </div>
        </main>
        <Footer/>
    </div>
</template>

<script>
import NavBar from '@/components/NavBar.vue'
import Footer from '@/components/Footer.vue'

export default {
    name: 'Contact',
    components: {
        NavBar,
        Footer
    }
}
</script>

<style scoped>
.github-profile-pic {
    width: 100%;
    border-radius: 2px;
    border: 1px solid #888888;
}

.contact-option-item {
    display: flex;
    word-break: break-all;
}

.contact-option-image {
    max-height: 25px;
    margin-right: 10px;
}
</style>