<template>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a class="navbar-brand" href="/">Sidney Simmons</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" :class="currentPage === 'software-engineer' ? 'active' : ''" href="/software-engineer">Software Engineer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" :class="currentPage === 'contact' ? 'active' : ''" href="/contact">Contact</a>
                </li>
            </ul>
        </div>
    </nav>
</template>

<script>
export default {
    name: "NavBar",
    props: {
        currentPage: String,
    },
};
</script>

<style scoped>
nav {
    margin-bottom: 15px;
}
</style>
