<template>
  <nav class="navbar">
    <img src="../assets/Corner Store Logo-modified.png" alt="CornerStore Logo" class="logo" />
    <div class="logo">CornerStore</div>
    <ul class="nav-links">
      <li><router-link to="/">Home</router-link></li>
      <li><router-link to="/products">Products</router-link></li>
      <!--<li><router-link to="/cart">Cart ({{ cart.items.length }})</router-link></li>
      <li><router-link to="/checkout">Checkout</router-link></li>-->
    </ul>
  </nav>
</template>

<script setup>
// No specific script logic needed for static navbar
</script>

<style scoped>
.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background: --vst-c-green;
  padding: 1rem;
  color: white;
}
.nav-links {
  list-style: none;
  display: flex;
  gap: 1rem;
}
.nav-links a {
  color: white;
  text-decoration: none;
}
.nav-links a:hover {
  text-decoration: underline;
}
</style>
