<template>
  <div class="contact">
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a class="navbar-brand" href="/">Sidney Simmons</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault">
            <span class="navbar-toggler-icon"></span>
        </button>
    
        <div class="collapse navbar-collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item"><a class="nav-link" href="/software-engineer">Software Engineer</a></li>
                <li class="nav-item active"><a class="nav-link" href="/contact">Contact</a></li>
            </ul>
        </div>
    </nav>
  </div>
</template>

<script>
import HelloWorld from '../../components/HelloWorld.vue'
export default {
  name: 'Contact',
  components: {
    HelloWorld
  }
}
</script>

<style scoped>

</style>