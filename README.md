# Movie Store


A project was undertaken to design a database system utilizing Hibernate for movie and store management. Hibernate was employed to create a robust mapping between the database entities, such as movies, actors, stores, inventories, and customers. This mapping facilitated efficient retrieval, storage, and management of movie-related data, including store inventory, customer rentals, payments, and store details, streamlining the overall movie and store management processes.

##
Please change to your user and password in hibernate.properties. 

### For testing 4 methods were created:
1. createCustomer();
2. customerReturnInventoryToStore();
3. customerRentInventory(customer);
4. newFilmWasMade();

All can be found in Main class.

No issue were found while local testing:
![Screenshot_8](https://github.com/nestserka/store_project/assets/78704791/b5761e1b-963e-43a1-a05f-99aa8eab3b64)


### Suggestion for improvements

1. Store Table Enhancement: You might add a column to the store table to store the time zone information for each store.
2. Actor table should also has boolen value active for filtering
3. Adding Currency to Payment Table or Using a Single Currency Across the System, otherwise it is not clear what transaction took place. 

![Screenshot_9](https://github.com/nestserka/store_project/assets/78704791/08338ace-0bb5-4e21-a20c-a2890e132a7f)



