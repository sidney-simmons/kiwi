<template>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a class="navbar-brand" href="/">{{ fullName }}</a>
        <button @click="open = !open" class="navbar-toggler" type="button">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div :class="{ show: open }" class="collapse navbar-collapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" :class="{ active: currentPage === 'software-engineer' }" href="/software-engineer">Software Engineer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" :class="{ active: currentPage === 'contact' }" href="/contact">Contact</a>
                </li>
            </ul>
        </div>
    </nav>
</template>

<script>
import PropertyService from "@/services/PropertyService.js";

export default {
    name: "NavBar",
    props: {
        currentPage: String,
    },
    data: function () {
        return {
            open: false,
            fullName: PropertyService.get("full-name"),
        };
    },
};
</script>

<style scoped>
nav {
    margin-bottom: 15px;
}
</style>
