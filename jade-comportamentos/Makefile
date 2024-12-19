PATH_PROJECT_JAR = target/jade-comportamentos-1.0-SNAPSHOT.jar
PROJECT_GROUP    = org.jade.agents
JADE_AGENTS      = Agent1:$(PROJECT_GROUP).MeuAgente;Andre:$(PROJECT_GROUP).AgenteImpressor(200);Maria:$(PROJECT_GROUP).AgenteImpressor(400);Paulo:$(PROJECT_GROUP).AgenteImpressor(600);
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

clean:
	@echo "Removendo a build do projeto"
	./mvnw clean

build-and-run-win:
	@echo "Gerando a build e executando o projeto"
	make build-win run

build-win:
	@echo "Gerando a build do projeto"
	.\mvnw clean install
