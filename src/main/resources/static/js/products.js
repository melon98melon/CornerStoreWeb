// getting data
        let products = []; 

        fetch('/api/products')
            .then(response => {
                response.json();})
            .then(data => {
            products = data; // store backend data in variable
            console.log(products);
            console.log("category: " + products.category);
        renderGrid();})
            .catch(error => console.error("Error fetching products:", error));


        // derive categories
        const categoriesSet = new Set(products.map(p => p.category));
        const categories = ["All", "Meat","Produce","Dairy","Dessert"];

        const grid = document.getElementById('grid');
        const categoriesEl = document.getElementById('categories');
        const searchInput = document.getElementById('search');
        const clearBtn = document.getElementById('clear-search');
        const noResults = document.getElementById('no-results');

        let activeCategory = 'All';
        let query = '';

        // persist likes in localStorage
        const likesKey = 'product_likes_v1';
        let likes = JSON.parse(localStorage.getItem(likesKey) || '{}');

        function saveLikes(){
            localStorage.setItem(likesKey, JSON.stringify(likes));
        }

        function makePlaceholderSvg(name, color){
            const initials = name.split(' ').map(s=>s[0]).slice(0,2).join('').toUpperCase();
            const svg = `<svg xmlns='http://www.w3.org/2000/svg' width='600' height='400'>
                <rect width='100%' height='100%' fill='${color}'/>
                <text x='50%' y='50%' dominant-baseline='middle' text-anchor='middle' font-size='64' font-family='sans-serif' fill='#fff'>${initials}</text>
            </svg>`;
            return 'data:image/svg+xml;charset=UTF-8,' + encodeURIComponent(svg);
        }

        function renderCategories(){
            categoriesEl.innerHTML = '';
            categories.forEach(cat => {
                const btn = document.createElement('button');
                btn.className = 'category-btn' + (cat===activeCategory ? ' active' : '');
                btn.textContent = cat;
                btn.onclick = () => {
                    activeCategory = cat;
                    renderGrid();
                };
                categoriesEl.appendChild(btn);
            });
        }

        function formatPrice(n){
            return '$' + n.toFixed(2);
        }

        function renderGrid(){
            const filtered = products.filter(p => {
                const matchesCategory = activeCategory === 'All' || p.category === activeCategory;
                console.log(p.category.name);
                const matchesQuery = !query || p.name.toLowerCase().includes(query.toLowerCase());
                return matchesCategory && matchesQuery;
            });

            grid.innerHTML = '';
            if(filtered.length === 0){
                noResults.style.display = '';
                return;
            } else {
                noResults.style.display = 'none';
            }

            filtered.forEach(p => {
                const card = document.createElement('div');
                card.className = 'card';
                card.innerHTML = `
                    <div class="thumb">
                        <img src="${p.image}" alt="${p.name}" />
                    </div>
                    <div class="card-body">
                        <div class="title-row">
                            <div class="product-name" title="${p.name}">${p.name}</div>
                            <div class="price">${formatPrice(p.price)}</div>
                        </div>
                        <div style="color:var(--muted); font-size:13px">${p.category}</div>
                        <div class="actions">
                            <button class="btn buy" data-id="${p.id}">Buy</button>
                            <button class="btn like" data-id="${p.id}">${likes[p.id] ? '♥' : '♡'}</button>
                        </div>
                    </div>
                `;
                grid.appendChild(card);

                // attach listeners
                const buyBtn = card.querySelector('.btn.buy');
                buyBtn.addEventListener('click', () => {
                    // placeholder action for buying
                    alert('Added "' + p.name + '" to cart — price ' + formatPrice(p.price));
                });

                const likeBtn = card.querySelector('.btn.like');
                likeBtn.addEventListener('click', () => {
                    likes[p.id] = !likes[p.id];
                    saveLikes();
                    likeBtn.textContent = likes[p.id] ? '♥' : '♡';
                });
            });
        }

        // events
        searchInput.addEventListener('input', (e) => {
            query = e.target.value.trim();
            renderGrid();
        });

        clearBtn.addEventListener('click', () => {
            searchInput.value = '';
            query = '';
            renderGrid();
        });

        // initialize
        renderCategories();
        renderGrid();

        // expose a place to change the title programmatically if needed
        // document.getElementById('page-title').textContent = 'New Title';