<template>
  <nav class="navbar">
    <img src="../assets/Corner Store Logo-modified.png" alt="CornerStore Logo" />
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
.logo {
  font-weight: bold;
  font-size: 1.5rem;
  color: black;
  display: flex;
  align-items: left;
  gap: 0.5rem;
}

img {
  width: 40px;
  height: 40px;
}
.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: white;
  padding: 1rem;
  color: black;
}
.nav-links {
  list-style: none;
  display: flex;
  align-items: center;
  gap: 1rem;
}
.nav-links a {
  color: black;
  text-decoration: none;
}
.nav-links a:hover {
  text-decoration: underline;
}
</style>
