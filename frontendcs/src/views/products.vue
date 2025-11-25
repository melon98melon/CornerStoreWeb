<template>
    <section class="products-gallery">
        <div
            class="card"
            v-for="product in products"
            :key="product.id"
            :aria-label="product.name"
        >
            <div class="image-wrap">
                <img :src="product.image || placeholder" :alt="product.name" />
                <span v-if="product.sale" class="badge">-{{ product.sale }}%</span>
            </div>

            <div class="info">
                <h3 class="name">{{ product.name }}</h3>

                <div class="price">
                    <span class="current">\${{ salePrice(product).toFixed(2) }}</span>
                    <span v-if="product.sale" class="original">\${{ product.price.toFixed(2) }}</span>
                </div>

                <div class="actions">
                    <button class="buy" @click="buy(product)">
                        Buy
                    </button>

                    <button
                        class="like"
                        :aria-pressed="isLiked(product)"
                        @click="toggleLike(product)"
                    >
                        <span class="heart" :class="{ liked: isLiked(product) }">♥</span>
                        <span class="count" v-if="likes[product.id]">{{ likes[product.id] }}</span>
                    </button>
                </div>
            </div>
        </div>
    </section>
</template>

<script setup>
import { reactive, ref } from 'vue'

const emit = defineEmits(['buy', 'like'])

// Placeholder or fallback image
const placeholder = 'https://via.placeholder.com/320x200?text=No+Image'

// Example products; replace with props or fetch as needed
const products = ref([
    { id: 1, name: 'Denim Jacket', price: 79.99, sale: 20, image: '' },
    { id: 2, name: 'Running Shoes', price: 120.0, sale: 0, image: '' },
    { id: 3, name: 'Classic Shirt', price: 45.5, sale: 10, image: '' },
    { id: 4, name: 'Leather Wallet', price: 35.0, sale: 0, image: '' },
])

// Simple likes store: map productId -> count (and treat >0 as liked)
const likes = reactive({})

// Toggle like: increment/decrement count and emit event
function toggleLike(product) {
    const id = product.id
    if (!likes[id]) likes[id] = 1
    else likes[id] = 0
    emit('like', { product, liked: !!likes[id] })
}

// Check if product is liked
function isLiked(product) {
    return !!likes[product.id]
}

// Buy handler: emit buy event (parent can handle adding to cart)
function buy(product) {
    emit('buy', product)
}

// Compute sale price
function salePrice(product) {
    if (!product.sale) return product.price
    return product.price * (1 - product.sale / 100)
}
</script>

<style scoped>
.products-gallery {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
    gap: 1rem;
    padding: 1rem;
}

.card {
    background: #fff;
    border-radius: 8px;
    box-shadow: 0 1px 4px rgba(16, 24, 40, 0.06);
    overflow: hidden;
    display: flex;
    flex-direction: column;
    height: 100%;
}

.image-wrap {
    position: relative;
    background: #f6f6f7;
    height: 140px;
    display: flex;
    align-items: center;
    justify-content: center;
}

.image-wrap img {
    max-width: 100%;
    max-height: 100%;
    object-fit: cover;
}

.badge {
    position: absolute;
    left: 8px;
    top: 8px;
    background: #e63946;
    color: white;
    padding: 4px 6px;
    border-radius: 6px;
    font-size: 12px;
    font-weight: 600;
}

.info {
    padding: 12px;
    display: flex;
    flex-direction: column;
    gap: 8px;
    flex: 1;
}

.name {
    margin: 0;
    font-size: 16px;
    line-height: 1.2;
    color: #111827;
}

.price {
    display: flex;
    align-items: baseline;
    gap: 8px;
}

.current {
    font-weight: 700;
    color: #0f172a;
}

.original {
    color: #6b7280;
    text-decoration: line-through;
    font-size: 13px;
}

.actions {
    margin-top: auto;
    display: flex;
    gap: 8px;
}

button {
    border: none;
    cursor: pointer;
    padding: 8px 10px;
    border-radius: 6px;
    font-weight: 600;
}

button.buy {
    background: #189929;
    color: white;
    flex: 1;
}

button.like {
    background: #f3f4f6;
    color: #1f2937;
    width: 72px;
    display: inline-flex;
    align-items: center;
    justify-content: center;
    gap: 6px;
}

.heart {
    transition: transform 0.12s ease;
    color: #9ca3af;
}

.heart.liked {
    color: #ef4444;
    transform: scale(1.08);
}

.count {
    font-size: 13px;
    color: #374151;
}
</style>