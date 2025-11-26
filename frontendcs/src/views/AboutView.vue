<!--<template>
  <div class="product-grid">
    <Card v-for="product in products" :key="product.id" class="product-card">
      <template #header>
        <img :src="product.image" alt="Product Image" class="product-image" />
      </template>
      <template #title>{{ product.name }}</template>
      <template #content>
        <p>{{ product.description }}</p>
        <p><strong>${{ product.price.toFixed(2) }}</strong></p>
        <Button label="Add to Cart" icon="pi pi-shopping-cart" />
      </template>
    </Card>
  </div>
</template>

<script>
import axios from 'axios';
import Card from 'primevue/card';
import Button from 'primevue/button';

export default {
  components: { Card, Button },
  data() {
    return { products: [] };
  },
  mounted() {
    axios.get('/api/products') // Spring Boot endpoint
      .then(res => this.products = res.data)
      .catch(err => console.error('Failed to load products:', err));
  }
};
</script>

<style scoped>
.product-grid {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
}
.product-card {
  width: 300px;
}
.product-image {
  width: 100%;
  height: 200px;
  object-fit: cover;
}
</style>
-->
<template>
  <div>
    <h1>About us</h1>
    <p>This is a project</p>
  </div>
</template>