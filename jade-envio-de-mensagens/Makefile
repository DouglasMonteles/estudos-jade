PATH_PROJECT_JAR = target/jade-envio-de-mensagens-1.0-SNAPSHOT.jar
PROJECT_GROUP    = org.jade.agents
JADE_AGENTS      = Bombeiro:$(PROJECT_GROUP).AgenteBombeiro;Alarmado:$(PROJECT_GROUP).AgenteAlarmado;
JADE_FLAGS 		 = -gui -agents "$(JADE_AGENTS)"

.PHONY:
	clean
	build-and-run

build-and-run:
	@echo "Gerando a build e executando o projeto"
	make build run

build:
	@echo "Gerando a build do projeto"
	./mvnw clean install

run:
	@echo "Executando o projeto com a última build criada"
	java -cp $(PATH_PROJECT_JAR) jade.Boot $(JADE_FLAGS)

run-bombeiro:
	@echo "Executando o agente bombeiro"
	java -cp $(PATH_PROJECT_JAR) jade.Boot -gui -agents Bombeiro:$(PROJECT_GROUP).AgenteBombeiro

run-alarme:
	@echo "Executando o agente alarme"
	java -cp $(PATH_PROJECT_JAR) jade.Boot -container -gui -agents A1:$(PROJECT_GROUP).AgenteAlarmado

run-contador:
	@echo "Executando o agente bombeiro"
	java -cp $(PATH_PROJECT_JAR) jade.Boot -gui -agents Contador:$(PROJECT_GROUP).AgenteContador

run-estoque:
	@echo "Executando o agente alarme"
	java -cp $(PATH_PROJECT_JAR) jade.Boot -container -gui -agents Estoque:$(PROJECT_GROUP).AgenteEstoque

clean:
	@echo "Removendo a build do projeto"
	./mvnw clean

build-and-run-win:
	@echo "Gerando a build e executando o projeto"
	make build-win run

build-win:
	@echo "Gerando a build do projeto"
	.\mvnw clean install
