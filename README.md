# Inventory Management System

## Overview
The **Inventory Management System** is a Java-based application designed to simplify inventory management tasks. It allows users to manage stock, process orders, track completed transactions, and generate detailed reports. The project showcases efficient use of Java data structures and demonstrates a modular and scalable design.

## Features
- **Add/Update Stock:** Add new items or update quantities of existing items.
- **Place Orders:** Process customer orders instantly or queue them if inventory is insufficient.
- **Manage Pending Orders:** Automatically process pending orders when stock is replenished.
- **Generate Reports:** Generate inventory and pending order reports.
- **Track Order History:** Maintain a history of completed orders.
- **Delete Items:** Remove obsolete items from the inventory.

## Project Structure
The project consists of three main files:
1. **`Main.java`** - Provides a menu-driven interface for the user to interact with the system.
2. **`InventorySystem.java`** - Contains the core inventory management logic and functionalities.
3. **`Product.java`** - Represents inventory items with attributes like name and quantity.

## How to Run
1. Clone or download the project repository.
2. Compile the Java files using the following command:
   ```sh
   javac Main.java InventorySystem.java Product.java
