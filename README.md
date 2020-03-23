# Bank-Managment-System
The Bank Managment System was my Java project in university 
GUI was done with the windows builder tool (drag and drop) using the swing library
The project starts with the welcomeInterface where you can either login as an admin using "Fekher" as username and "Nouioui" as password,
this way you will end up in the admin interface where you can see informations such as number of accounts ..
The other way is to login as a client where you will get an interface suitable for your account type (salary,vip,saving)
The database has 4 tables:
  1/agence : contains information about the bank agency
  2/client : contains information about the client, we have 2 types of clients, a normal client and a vip client, a normal client can
  create a salary account or a saving account while a vip account can create all the accounts type, the typeClient attribut is used to 
  determinate the client type
  3/compte : contains all the information about the account with some attributes(dateDernierVersement,dateCreation,montantMensuel)
  meant to be used by the saving accounts
  4/transaction : a table where we take into account all the transactions made by the user 
