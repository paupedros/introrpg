TAULES DE VERITAT
#################

Taula 1
*******
La Clara és major d'edat o bé la Clara és més jove que el Marc
==============================================================
La Clara és major d'edat --> edatClara => 18 --> A
La Clara és més jove que el Marc --> edatClara < edatMarc --> B

 ==== ======= ======= =========
  nr   A       B       "A || B"                    
 ==== ======= ======= =========
  1    true    true    true                      
  2    false   true    true                      
  3    true    false   true                      
  4    false   false   false                     
 ==== ======= ======= =========

Taula 3
*******
La Clara és major d'edat, i tu ets major que el Marc però no major que la Clara
===============================================================================
La Clara és major d'edat --> edatClara => 18 --> A
Tu ets major que el Marc --> edatTeva > edatMarc --> B
Però no major que la Clara --> edatTeva < edatClara --> C

 ==== ======= ======= ======= =============
  nr   A       B       C       A && B && C                 
 ==== ======= ======= ======= =============
  1    true    true    true    true                        
  2    false   true    true    false                       
  3    true    false   true    false                       
  4    false   false   false   false                       
  5    true    true    false   false                       
  6    false   true    false   false                                     
 ==== ======= ======= ======= =============



