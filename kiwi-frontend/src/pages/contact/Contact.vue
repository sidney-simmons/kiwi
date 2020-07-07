<template>
    <div>
        <NavBar currentPage="contact"/>
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

</style>