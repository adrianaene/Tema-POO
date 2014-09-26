Nume: Ene

Prenume: Adriana

Grupa: 321CC

Grad de dificultate:9

Timp alocat: doua saptamani

Implementare:

Am creat pachetul elevi cu toate clasele necesare, creand si o clasa test in care verific metodele implementate.

Am creat pachetul grafic care contine o parte din interfata grafica, dar nu este finalizat.


Cum am realizat salvarea datelor pe disc:

In metoda getInstance din clasa Centralizator, cea care trebuie sa returneze
singura instanta a singletonului Centralizator, am verificat intai daca exista
fisierul binar "data" in care am incarcat inainte toti utilizatorii si clasele.
Daca fisierul "data" exista, citim din el instanta de centralizator cu care vom
lucra in programul rulat curent. Daca nu exista, va fi creata o noua instanta de 
centralizator. Astfel indeplinim conditia sa existe o singura instanta de centralizator.


