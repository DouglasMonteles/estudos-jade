PATH_PROJECT_JAR = target/jade-df-solicitando-ajuda-1.0-SNAPSHOT.jar
PROJECT_GROUP    = org.jade.agents
JADE_AGENTS      = Pedinte:$(PROJECT_GROUP).Solicitante(fogo); Bombeiro:$(PROJECT_GROUP).Bombeiro; Medico:$(PROJECT_GROUP).Medico; Policial:$(PROJECT_GROUP).Policial;
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
