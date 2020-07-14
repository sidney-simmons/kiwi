<template>
    <div>
        <NavBar currentPage="software-engineer" />
        <main role="main" class="container-fluid">
            <div class="row">
                <h2 class="section-title">GitHub Repositories</h2>
            </div>
            <div class="row">
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
                                <a :href="repository.htmlUrl" class="js-repository-link">{{ repository.htmlUrl }}</a>
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
            repositories: [],
        };
    },
    mounted: function () {
        this.setRepositories();
    },
    methods: {
        setRepositories: function () {
            SoftwareApi.getRepositories()
                .then((response) => {
                    this.repositories = response.data.repositories;
                })
                .catch((error) => {
                    console.error(error);
                    this.repositories = [];
                });
        },
        formatLastUpdated: function (updatedAtUtcString) {
            let updatedAtDate = moment(updatedAtUtcString);
            return "Last updated: " + updatedAtDate.fromNow();
        },
    },
};
</script>

<style scoped></style>
