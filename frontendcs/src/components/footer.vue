<template>
    <div id="wrapper">
    <footer class="footer" role="contentinfo" aria-label="Site footer">
        <div class="container">
            <div class="brand">
                <svg class="logo" viewBox="0 0 24 24" aria-hidden="true" focusable="false">
                    <rect x="3" y="3" width="18" height="18" rx="3" fill="currentColor" />
                    <path d="M7 12h10" stroke="#fff" stroke-width="1.5" stroke-linecap="round"/>
                </svg>
                <span class="brand-name">CornerStore</span>
            </div>

            <nav class="links" aria-label="Footer navigation">
                <a href="/" class="link">Home</a>
                <a href="#" class="link">About</a>
                <a href="/products" class="link">Products</a>
            </nav>
        </div>

        <div class="bottom">
            <small>© {{ year }} CornerStore.</small>
        </div>
    </footer>
    </div>
</template>

<script setup>
import { ref } from 'vue'
const year = ref(new Date().getFullYear())
</script>

<style scoped>
.wrapper {
  position: relative;
  min-height: 100dvh;
}

.footer {
    bottom:0;
    position:absolute;
    width:100%;
    background: white;
    color: black;
    padding: 24px 16px;
    border-top: 1px solid rgba(255,255,255,0.04);
}

.container {
    display: flex;
    gap: 16px;
    align-items: center;
    justify-content: space-between;
    max-width: 1100px;
    margin: 0 auto;
    flex-wrap: wrap;
}

.brand {
    display: flex;
    align-items: center;
    gap: 10px;
    min-width: 160px;
}

.logo {
    width: 36px;
    height: 36px;
    color: #60a5fa;
    flex-shrink: 0;
}

.brand-name {
    font-weight: 600;
    font-size: 1.05rem;
    letter-spacing: 0.2px;
}

.links {
    display: flex;
    gap: 12px;
    flex-wrap: wrap;
    justify-content: center;
    flex: 1 1 auto;
}

.link {
    color: black;
    text-decoration: none;
    font-size: 0.95rem;
    padding: 6px 8px;
    border-radius: 6px;
}
.link:hover,
.link:focus {
    background: rgba(255,255,255,0.03);
    color: #fff;
    outline: none;
}

.bottom {
    max-width: 1100px;
    margin: 14px auto 0;
    text-align: center;
    color: rgba(203,213,225,0.8);
    font-size: 0.88rem;
}

/* Responsive */
@media (max-width: 720px) {
    .container { gap: 12px; }
    .links { order: 2; width: 100%; justify-content: space-around; margin-top: 8px; }
    .brand { order: 1; }
}
</style>