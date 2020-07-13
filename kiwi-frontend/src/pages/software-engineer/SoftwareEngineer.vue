<template>
    <div>
        <NavBar currentPage="software-engineer" />
        <Footer />
    </div>
</template>

<script>
import NavBar from "@/components/NavBar.vue";
import Footer from "@/components/Footer.vue";

export default {
    name: "SoftwareEngineer",
    components: {
        NavBar,
        Footer,
    },
};
</script>

<style scoped></style>
