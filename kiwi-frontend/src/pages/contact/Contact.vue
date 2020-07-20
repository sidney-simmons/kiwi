<template>
    <div>
        <NavBar currentPage="contact" />
        <main role="main" class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <h2 class="section-title">Reach Out!</h2>
                </div>
                <div class="col-12 col-sm-7 col-md-7 col-lg-7 col-xl-9 margin-bottom">
                    <ul class="list-group">
                        <li class="list-group-item contact-option-item">
                            <img src="@/assets/images/baseline_email_black_18dp.png" class="contact-option-image" />
                            <div class="contact-option-text">
                                <a :href="'mailto:' + emailAddress" @click="contactLinkClicked($event)" class="js-contact-link">{{ emailAddress }}</a>
                            </div>
                        </li>
                        <li class="list-group-item contact-option-item">
                            <img src="@/assets/images/baseline_call_black_18dp.png" class="contact-option-image" />
                            <div class="contact-option-text">
                                <a :href="phoneNumberHref" @click="contactLinkClicked($event)" class="js-contact-link">{{ phoneNumber }}</a>
                            </div>
                        </li>
                        <li class="list-group-item contact-option-item">
                            <img src="@/assets/images/baseline_place_black_18dp.png" class="contact-option-image" />
                            <div class="contact-option-text">{{ location }}</div>
                        </li>
                        <li class="list-group-item contact-option-item">
                            <img src="@/assets/images/baseline_code_black_18dp.png" class="contact-option-image" />
                            <div class="contact-option-text">
                                <a :href="githubProfileUrl" @click="contactLinkClicked($event)" class="js-contact-link">{{ githubProfileUrl }}</a>
                            </div>
                        </li>
                        <li class="list-group-item contact-option-item">
                            <img src="@/assets/images/baseline_work_black_18dp.png" class="contact-option-image" />
                            <div class="contact-option-text">
                                <a :href="linkedinUrl" @click="contactLinkClicked($event)" class="js-contact-link">{{ linkedinUrl }}</a>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="col-12 col-sm-5 col-md-5 col-lg-5 col-xl-3 margin-bottom">
                    <img :src="githubPhotoUrl" class="github-profile-pic" />
                </div>
            </div>
        </main>
        <Footer />
    </div>
</template>

<script>
import PropertyService from "@/services/PropertyService";
import GoogleAnalyticsService from "@/services/GoogleAnalyticsService";
import NavBar from "@/components/NavBar.vue";
import Footer from "@/components/Footer.vue";

export default {
    name: "Contact",
    components: {
        NavBar,
        Footer,
    },
    data: function () {
        return {
            emailAddress: PropertyService.get("email-address"),
            phoneNumber: PropertyService.get("phone-number"),
            phoneNumberHref: PropertyService.get("phone-number-href"),
            location: PropertyService.get("location"),
            githubProfileUrl: PropertyService.get("github-profile-url"),
            githubPhotoUrl: PropertyService.get("github-photo-url"),
            linkedinUrl: PropertyService.get("linkedin-url"),
        };
    },
    methods: {
        contactLinkClicked: function (event) {
            GoogleAnalyticsService.triggerGoogleAnalyticsEvent("links", "contact-link-clicked", event.target.href);
        },
    },
};
</script>

<style scoped>
.github-profile-pic {
    width: 100%;
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
