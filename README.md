#ISTRUZIONI PER IL CORRETTO AVVIO SU http://localhost:8888/app
docker build -t jtrac .
docker run --network host --name jtrac jtrac


#PRIMA DI INIZIARE QUALSIASI TEST
python3 Lang_IT.py
