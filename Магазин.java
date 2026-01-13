import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Создаем товары
        Product laptop = new Product("Ноутбук", 75000.0);
        Product mouse = new Product("Мышка", 1500.0);
        Product keyboard = new Product("Клавиатура", 3000.0);
        Product headphones = new Product("Наушники", 5000.0);
        
        // Создаем корзину
        Cart cart = new Cart();
        
        // Добавляем товары в корзину
        cart.addProduct(laptop);
        cart.addProduct(mouse);
        cart.addProduct(keyboard);
        cart.addProduct(headphones);
        
        // Показываем начальное состояние корзины
        System.out.println("=== Начальная корзина ===");
        cart.printCart();
        System.out.println();
        
        // Удаляем один товар
        System.out.println("Удаляем: Мышка\n");
        cart.removeProduct("Мышка");
        
        // Показываем обновленную корзину
        System.out.println("=== Корзина после удаления ===");
        cart.printCart();
        
        // Дополнительные операции для демонстрации
        System.out.println("\n=== Дополнительные операции ===");
        
        // Попытка удалить несуществующий товар
        System.out.println("Попытка удалить несуществующий товар 'Планшет':");
        cart.removeProduct("Планшет");
        
        // Добавляем еще один товар
        System.out.println("\nДобавляем новый товар 'Монитор':");
        Product monitor = new Product("Монитор", 25000.0);
        cart.addProduct(monitor);
        cart.printCart();
    }
}

// Класс Product (товар)
class Product {
    private String name;
    private double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    // Геттеры
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return name + " – " + price + " руб.";
    }
}

// Класс Cart (корзина)
class Cart {
    private ArrayList<Product> products;
    
    public Cart() {
        products = new ArrayList<>();
    }
    
    // Добавить товар в корзину
    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
            System.out.println("Товар '" + product.getName() + "' добавлен в корзину.");
        }
    }
    
    // Удалить товар по названию
    public boolean removeProduct(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equalsIgnoreCase(name)) {
                Product removed = products.remove(i);
                System.out.println("Товар '" + removed.getName() + "' удален из корзины.");
                return true;
            }
        }
        System.out.println("Товар с названием '" + name + "' не найден в корзине.");
        return false;
    }
    
    // Посчитать общую сумму
    public double getTotal() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
    
    // Вывести содержимое корзины
    public void printCart() {
        System.out.println("=== Корзина ===");
        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i));
            }
            System.out.println("Итого: " + getTotal() + " руб.");
        }
        System.out.println();
    }
    
    // Дополнительный метод для получения списка товаров (может пригодиться)
    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products); // Возвращаем копию для защиты от изменений
    }
    
    // Дополнительный метод для очистки корзины
    public void clearCart() {
        products.clear();
        System.out.println("Корзина очищена.");
    }
}
