<script setup>
import { RouterLink, RouterView } from 'vue-router'
import Footer from './components/footer.vue';
import Navbar from './components/navbar.vue';
</script>


<template>
  <Navbar/>
  <router-view />
  <Footer/>
  <RouterView />
</template>

<style scoped>

/*header {
  line-height: 1.5;
  max-height: 100vh;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }

}*/
</style>
