# JTrac

[Vedi pagina sourceforge](https://sourceforge.net/projects/j-trac/)

## Avvio applicativo

Prima dell'avvio dell'applicativo sarà necessario scegliere una delle versioni disponibili nella cartella Versions.\
Per modificare la versione sarà necessario modificare la riga seguente nel DockerFile cambiando Versions/2.2.0/  in Versions/{Nome versione disponibile nella cartella Versions}/

```
COPY Versions/2.2.0/ .
```
Per avviare l'applicativo:
```
docker build -t jtrac .
docker run --network host --name jtrac jtrac
```
## Terminare applicativo
```
docker stop jtrac
```

## Configurazione applicativo
Prima di ogni test sarà necessario impostare la lingua italiana manualmente oppure mandando in esecuzione il seguente script python
```
python3 Lang_IT.py
```


