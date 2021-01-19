# Asemetrisk kryptering 2020-01-19

###### Att göra efter lektionen:

* läsa på om RSA

* Inlämning RSA

* 

#### Cryptopals

python: **tobytearray**

----

Jag skickar ett krypterat medelande -> mottagern krypterar och skickar tillbaka meddelandet ==> jag avkrypterar min kryptering och skickar till motagaren ==> motagren avkrypterar medelandet

#### 2 vägs funktioner

ta ett tal - dubblerar det - ger er talet och talar om att det är dubblerar det - ni delar det med 2 och läser medelandet

##### 1 vägs funkton

en funktion som är svår att rotera tillbaka

blå + gul = grön

grön != blå + gul

#### RSA

rsa använder privata och publicka nycklar

meddelanden som har krypterats med den publika nyclen kan endast deckrypteras  med den publika nyclken

privat och publika nyklar

* säkerheten bakom

* hur man får till säkerheten
1. välj två stora primtal, kalla dom p och q 2 3 5 7 11

2. ex
   
   * p = 5
   
   * q = 11
   
   * n = p * q = 55
   
   * φ(n) = 40
   
   * e = 7
   
   $ e * d mod φ(n) = 1 $

3. vällj ett tal e

4. 
* Eulers fi-function eller Euler's totient function

* Om n är ett positivs heltal, tå definieras fi(n) som telet positiva heltal mindre än eller lika med n som är relativs prima med n. till exempel är fi(8) = 4 eftersom de fyra talen 1 3 5 och 7 är relativs prima till 8

* två tal anses vara relativs prima om dertas störta gemensamma delare
  
  faktorisera 55 så har du p och q

beräkna d

| φ(n) | φ(n) |
| ---- | ---- |
| 40   | 40   |
| 7    | 1    |
| 5    |      |
|      |      |
|      |      |

p = 5

q = 11

n = 55

φ(n)

6 har faktorerna 2 och 3

om vi vill att n sska ll bara 4096 birtar skal p och q vara 2048

två tal som är 617 bitar

det är ett tal som 1234 siffror,

talet gogol är stort , $10 ^ 100$

* kryptera texten bil

* ascii 2, 9, 12

* m ^ e mod n = c

Har jag er pu
