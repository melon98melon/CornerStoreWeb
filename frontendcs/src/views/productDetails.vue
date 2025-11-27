<template>
    <div class="go-back">
        <router-link to="/products">Back to Products</router-link>
    </div>
    <div class="product-details-container">
        <div class="product-card">
            <div class="product-image">
                <img :src="product.image" :alt="product.name" />
            </div>
            <div class="product-info">
                <h1 class="product-name">{{ product.name }}</h1>
                <p class="product-details">{{ product.details }}</p>
                <p class="product-price">${{ product.price }}</p>
                <button class="buy-button">Buy</button>
            </div>
        </div>
    </div>
</template>

<script>
import { RouterLink } from 'vue-router';
export default {
    name: 'ProductDetails',
    data() {
        return {
            product: {
                name: 'Product Name',
                image: 'https://via.placeholder.com/300',
                details: 'Product details go here',
                price: 29.99
            }
        };
    }
};
</script>

<style scoped>
.go-back {
    margin: 20px;
    background-color: var(--green);
    padding: 10px 15px;
    border-radius: 5px;
    display: inline;
}
.product-details-container {
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    padding: 20px;
    background-color: #f5f5f5;
}

.product-card {
    display: flex;
    background: white;
    border-radius: 8px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
    max-width: 600px;
    overflow: hidden;
}

.product-image {
    flex: 0 0 500px;
}

.product-image img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.product-info {
    flex: 1;
    padding: 30px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}

.product-name {
    font-size: 24px;
    margin: 0 0 15px 0;
    color: #333;
}

.product-details {
    font-size: 14px;
    color: #666;
    margin: 0 0 20px 0;
    line-height: 1.6;
}

.product-price {
    font-size: 20px;
    font-weight: bold;
    color: #2c3e50;
    margin: 0 0 20px 0;
}

.buy-button {
    padding: 10px 20px;
    background-color: var(--green);
    color: white;
    border: none;
    border-radius: 4px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.buy-button:hover {
    background-color: #369970;
}
</style>