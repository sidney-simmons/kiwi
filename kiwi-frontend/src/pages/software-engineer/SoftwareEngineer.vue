<template>
    <div>
        <NavBar currentPage="software-engineer" />
        <main role="main" class="container-fluid">
            <div class="row">
                <h2 class="section-title">GitHub Repositories</h2>
            </div>
            <div class="row">
                <div v-if="loadingRepositories" class="section-container">
                    <div class="loading-indicator">Loading...</div>
                </div>
                <div v-if="loadingRepositoriesErrorMessage" class="alert alert-danger section-container" role="alert">
                    {{ 'Cannot load repositories: "' + loadingRepositoriesErrorMessage + '"' }}
                </div>
                <div
                    v-for="repository in repositories"
                    :key="repository.name"
                    class="repository-container margin-bottom col-12 col-sm-6 col-md-4 col-lg-3"
                >
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">{{ repository.name }}</h5>
                            <p class="card-text">{{ repository.description }}</p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                                <a :href="repository.htmlUrl" @click="repositoryLinkClicked($event)" class="js-repository-link">{{
                                    repository.htmlUrl
                                }}</a>
                            </li>
                        </ul>
                        <div class="card-footer">
                            <small class="text-muted js-repository-updated-at">{{ formatLastUpdated(repository.updatedAt) }}</small>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <Footer />
    </div>
</template>

<script>
import SoftwareApi from "@/services/SoftwareApi.js";
import GoogleAnalyticsService from "@/services/GoogleAnalyticsService.js";
import NavBar from "@/components/NavBar.vue";
import Footer from "@/components/Footer.vue";
import moment from "moment/dist/moment";

export default {
    name: "SoftwareEngineer",
    components: {
        NavBar,
        Footer,
    },
    data: function () {
        return {
            loadingRepositories: false,
            loadingRepositoriesErrorMessage: null,
            repositories: [],
        };
    },
    mounted: function () {
        this.setRepositories();
    },
    methods: {
        setRepositories: function () {
            // Show loading indicator
            this.loadingRepositories = true;

            // Get the repositories
            SoftwareApi.getRepositories()
                .then((response) => {
                    this.repositories = response.data.repositories;
                    this.loadingRepositoriesErrorMessage = null;
                })
                .catch((error) => {
                    this.repositories = [];
                    this.loadingRepositoriesErrorMessage = error.message;
                })
                .then(() => {
                    this.loadingRepositories = false;
                });
        },
        formatLastUpdated: function (updatedAtUtcString) {
            let updatedAtDate = moment(updatedAtUtcString);
            return "Last updated: " + updatedAtDate.fromNow();
        },
        repositoryLinkClicked: function (event) {
            GoogleAnalyticsService.triggerGoogleAnalyticsEvent("links", "github-repo-link-clicked", event.target.href);
        },
    },
};
</script>

<style scoped>
.loading-indicator {
    font-style: italic;
    animation-name: example;
    animation-duration: 0.5s;
    animation-direction: alternate;
    animation-iteration-count: infinite;
    animation-timing-function: linear;
}
@keyframes example {
    0% {
        opacity: 0;
    }
    100% {
        opacity: 1;
    }
}
</style>
