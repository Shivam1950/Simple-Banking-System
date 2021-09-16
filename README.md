## Working


Once the program starts this menu is printed:


    1. Balance
    2. Add income  
    3. Do transfer
    4. Close account
    5. Log out
    0. Exit


If the user asks for Balance, balance from the account will be read from the database and outputed into the console.


Add income item will allow us to deposit money to the account.


Do transfer item will allow transferring money to another account. 


Program handle the following errors:


1.If the user tries to transfer more money than he/she has, output: Not enough money!
2.If the user tries to transfer money to the same account, output the following message: You can't transfer money to the same account!
3.If the receiver's card number doesn’t pass the Luhn algorithm, you should output: Probably you made a mistake in the card number. Please try again!
4.If the receiver's card number doesn’t exist, you should output: Such a card does not exist.
5.If there is no error, ask the user how much money they want to transfer and make the transaction.


If the user chooses the Close an account item, you should delete that account from the database.
