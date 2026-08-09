async function loadFood() {
    const container = document.getElementById("food-container");

    try {
        const response = await fetch("/api/foods");

        if (!response.ok) {
            throw new Error("Failed to load food");
        }

        const foods = await response.json();

        container.innerHTML = foods.map(food => `
            <div class="card">
                <h3>${food.name}</h3>
                <p>Category: ${food.category}</p>
                <p class="price">₹${food.price}</p>
                <p class="${food.available ? 'available' : 'unavailable'}">
                    ${food.available ? 'Available' : 'Not Available'}
                </p>
            </div>
        `).join("");

    } catch (error) {
        container.innerHTML =
            `<div class="error">Unable to load food data.</div>`;
    }
}


async function loadGroceries() {
    const container = document.getElementById("grocery-container");

    try {
        const response = await fetch("/api/groceries");

        if (!response.ok) {
            throw new Error("Failed to load groceries");
        }

        const groceries = await response.json();

        container.innerHTML = groceries.map(item => `
            <div class="card">
                <h3>${item.name}</h3>
                <p>Category: ${item.category}</p>
                <p class="price">₹${item.price}</p>
                <p class="${item.available ? 'available' : 'unavailable'}">
                    ${item.available ? 'Available' : 'Not Available'}
                </p>
            </div>
        `).join("");

    } catch (error) {
        container.innerHTML =
            `<div class="error">Unable to load grocery data.</div>`;
    }
}


async function loadDineout() {
    const container = document.getElementById("dineout-container");

    try {
        const response = await fetch("/api/dineouts");

        if (!response.ok) {
            throw new Error("Failed to load dineout");
        }

        const restaurants = await response.json();

        container.innerHTML = restaurants.map(restaurant => `
            <div class="card">
                <h3>${restaurant.name}</h3>
                <p>Cuisine: ${restaurant.cuisine}</p>
                <p>Location: ${restaurant.location}</p>
                <p class="price">
                    Average Price: ₹${restaurant.averagePrice}
                </p>
                <p class="${restaurant.available ? 'available' : 'unavailable'}">
                    ${restaurant.available ? 'Available' : 'Not Available'}
                </p>
            </div>
        `).join("");

    } catch (error) {
        container.innerHTML =
            `<div class="error">Unable to load dineout data.</div>`;
    }
}


loadFood();
loadGroceries();
loadDineout();
