<template>
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
                <a href="#" class="link">Contact</a>
                <a href="#" class="link">Terms</a>
                <a href="#" class="link">Privacy</a>
            </nav>

            <div class="social" aria-label="Social links">
                <a href="https://github.com" target="_blank" rel="noopener" class="social-link" aria-label="GitHub">
                    <svg viewBox="0 0 24 24" aria-hidden="true" focusable="false">
                        <path fill="currentColor" d="M12 .5a12 12 0 00-3.8 23.4c.6.1.8-.2.8-.5v-1.9c-3.3.7-4-1.4-4-1.4-.5-1.2-1.2-1.5-1.2-1.5-1-.7.1-.7.1-.7 1.1.1 1.7 1.2 1.7 1.2 1 .1 1.6-.7 2-1 .1-.8.4-1.3.7-1.6-2.6-.3-5.3-1.3-5.3-5.8 0-1.3.5-2.4 1.2-3.2-.1-.3-.5-1.6.1-3.2 0 0 1-.3 3.3 1.2a11.4 11.4 0 016 0C17.7 5 18.7 5.3 18.7 5.3c.6 1.6.2 2.9.1 3.2.8.8 1.2 1.9 1.2 3.2 0 4.5-2.7 5.5-5.3 5.8.4.3.8 1 .8 2v3c0 .3.2.6.8.5A12 12 0 0012 .5z"/>
                    </svg>
                </a>
            </div>
        </div>

        <div class="bottom">
            <small>© {{ year }} CornerStore.</small>
        </div>
    </footer>
</template>

<script setup>
import { ref } from 'vue'
const year = ref(new Date().getFullYear())
</script>

<style scoped>
.footer {
    background: linear-gradient(180deg, #0f1724, #071024);
    color: #dbeafe;
    padding: 24px 16px;
    font-family: system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial;
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
    color: #cbd5e1;
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

.social {
    display: flex;
    gap: 10px;
    align-items: center;
    min-width: 120px;
    justify-content: flex-end;
}

.social-link {
    display: inline-flex;
    width: 36px;
    height: 36px;
    align-items: center;
    justify-content: center;
    color: #cbd5e1;
    border-radius: 6px;
    text-decoration: none;
}
.social-link svg {
    width: 20px;
    height: 20px;
}
.social-link:hover,
.social-link:focus {
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
    .links { order: 3; width: 100%; justify-content: space-around; margin-top: 8px; }
    .social { order: 2; }
    .brand { order: 1; }
}
</style>