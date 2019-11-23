# Neuronová síť RCE
Implementace algoritmu neuronové sítě RCE s řešenou úlohou balančních vah.

## Překlad
V kořenovém adresáři je soubor `build.xml`, který obsahuje informace potřebné k překladu pomocí nástroje Apache Ant. Stačí tedy v tomto adresáři použít příkaz:

    ant compile

Tímto se vytvoří spustitelná aplikace `sfc-rce.jar` a vygeneruje se programová dokumentace do adresáře `doc/program`

## Použití
Příklady použití aplikace `sfc-rce.jar`

Aplikace se spustí pomocí příkazu (bez natrénované sítě):

    java -jar sfc-rce.jar

Spuštění a natrénování sítě na zvoleném datasetu:

    java -jar sfc-rce.jar -t dataset/balance-scale-training.data

Spuštění a natrénování sítě na zvoleném datasetu a validačním datasetu:

    java -jar sfc-rce.jar -t dataset/balance-scale-training.data -v dataset/balance-scale-validation.data

Spuštění a natrénování sítě na zvoleném datasetu a definováním vlastních parametru sítě (Maximální poloměr 2 a zmenšovací poměr 0.5):

    java -jar sfc-rce.jar -t dataset/balance-scale-training.data -R 2 -r 0.5


## Důležité informace
Úspěšně otestováno na Ubuntu verze 18.04 a Java verze 1.8
