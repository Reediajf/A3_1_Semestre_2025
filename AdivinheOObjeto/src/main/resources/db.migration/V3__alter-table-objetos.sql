DROP TABLE IF EXISTS Objetos;

CREATE TABLE Objetos (
         id INT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(255) NOT NULL,
        dica VARCHAR(100) NOT NULL,
        dica2 VARCHAR(100) NOT NULL ,
        dica3 VARCHAR(100) NOT NULL ,
        categoria VARCHAR(100) NOT NULL
                             );

INSERT INTO Objetos (nome, dica, dica2, dica3, categoria) VALUES
('Caderno', 'Usamos para escrever e desenhar.', 'Ele é muito útil na escola.', 'Tem várias páginas que podemos preencher.', 'Educação de Qualidade'),
('Lápis', 'Temos que apontar para usar.', 'Usamos para escrever e desenhar.', 'Pode quebrar se cair no chão.', 'Educação de Qualidade'),
('Livro', 'Tem histórias e aprendizados.', 'Podemos aprender muitas coisas com ele.', 'Ele tem várias páginas.', 'Educação de Qualidade'),
('Caneta', 'Usamos para escrever de forma permanente.', 'Ela pode ser azul, preta ou vermelha.', 'Cuidado para não borrar o papel.', 'Educação de Qualidade'),
('Borracha', 'Ela apaga o que escrevemos.', 'Normalmente, é feita de borracha.', 'A borracha serve para corrigir erros.', 'Educação de Qualidade'),
('Mochila', 'Usamos para carregar os materiais.', 'Ela tem zíper e alças.', 'Temos que carregar ela nas costas.', 'Educação de Qualidade'),
('Tesoura', 'Tem lâminas afiadas e usamos para cortar.', 'É importante ter cuidado ao usar.', 'Ela pode ser colorida e tem cabo para segurar.', 'Educação de Qualidade'),
('Agenda', 'Ela ajuda a organizar os dias e compromissos.', 'Você pode escrever nela todos os dias.', 'Ela pode ter uma capa bonita e colorida.', 'Educação de Qualidade'),
('Computador', 'Usamos para estudar e navegar na internet.', 'Ele tem uma tela e um teclado.', 'Com ele, podemos jogar e aprender.', 'Indústria, Inovação e Infraestrutura'),
('Celular', 'Ele é como um mini-computador.', 'Podemos ligar e mandar mensagens.', 'Tem uma tela que podemos tocar.', 'Indústria, Inovação e Infraestrutura'),
('Rádio', 'Usamos para escutar músicas ou notícias.', 'Temos rádios em casa ou no carro.', 'Fica emitindo som, e podemos mudar a estação.', 'Indústria, Inovação e Infraestrutura'),
('Câmera', 'Usamos para tirar fotos e guardar momentos.', 'Ela pode ser de um celular ou uma câmera especial.', 'Ela pode ter lentes e botões.', 'Indústria, Inovação e Infraestrutura'),
('Calculadora', 'Usamos para fazer contas rapidamente.', 'Ela tem botões com números.', 'Muito útil para aprender matemática.', 'Educação de Qualidade'),
('Relógio', 'Nos ajuda a saber a hora.', 'Ele pode ser de pulso ou de parede.', 'Alguns relógios têm ponteiros, outros digitais.', 'Vida na Água'),
('Ventilador', 'Ele ajuda a refrescar o ambiente.', 'Gira rapidamente e faz vento.', 'Usamos muito no verão para ter ar fresco.', 'Cidades e Comunidades Sustentáveis'),
('Ar Condicionado', 'Ele controla a temperatura do ambiente.', 'Ele pode esfriar ou aquecer o ar.', 'Usamos ele no verão para refrescar.', 'Cidades e Comunidades Sustentáveis'),
('Mesa', 'É onde colocamos livros, comida ou outros objetos.', 'Ela tem quatro pés e pode ser de madeira ou metal.', 'Podemos usá-la para estudar ou comer.', 'Objetos do Dia a Dia'),
('Cadeira', 'Sentamos nela para descansar ou estudar.', 'Ela tem quatro pernas e pode ter braço.', 'Temos cadeiras em escolas e casas.', 'Objetos do Dia a Dia'),
('Janela', 'Podemos abrir para deixar o ar entrar.', 'Ela tem vidro e fica na parede.', 'Com ela, podemos ver o lado de fora.', 'Objetos do Dia a Dia'),
('Porta', 'Usamos para entrar ou sair de um lugar.', 'Ela pode ser de madeira ou vidro.', 'Você pode abri-la ou fechá-la.', 'Objetos do Dia a Dia'),
('Ferro de Passar', 'Usamos para deixar as roupas sem rugas.', 'Ele esquenta e tem uma base metálica.', 'Você deve usar com cuidado para não se queimar.', 'Objetos do Dia a Dia'),
('Fogão', 'Usamos para cozinhar os alimentos.', 'Tem bocas onde colocamos panelas.', 'Temos que ter cuidado para não nos queimar.', 'Objetos do Dia a Dia'),
('Geladeira', 'Ela mantém os alimentos gelados.', 'Usamos para guardar frutas, sucos e outros alimentos.', 'Ela ajuda a manter a comida fresca.', 'Objetos do Dia a Dia'),
('Lixeira', 'Usamos para jogar lixo fora.', 'Ela pode ser encontrada em muitos lugares.', 'É importante manter a lixeira limpa.', 'Consumo e Produção Responsáveis'),
('Cachorro', 'É um animal muito amigável.', 'Ele late e gosta de brincar.', 'Ele é um dos animais de estimação mais comuns.', 'Vida Terrestre'),
('Gato', 'É um animal que gosta de caçar ratos.', 'Ele mia e adora dormir em lugares quentinhos.', 'O gato é muito independente.', 'Vida Terrestre'),
('Pato', 'Vive em lugares com água.', 'Ele tem um bico largo e adora nadar.', 'É um animal muito engraçado e gosta de voar.', 'Vida na Água'),
('Cavalo', 'Ele é grande e muito forte.', 'Gostamos de montar nele em passeios.', 'Ele adora correr no campo.', 'Vida Terrestre'),
('Peixe', 'Vive dentro da água e tem escamas.', 'Ele nada e respira com brânquias.', 'Os peixes podem ter muitos tamanhos e cores.', 'Vida na Água'),
('Leão', 'É chamado de o rei da selva.', 'Ele tem uma grande juba e é muito forte.', 'O leão gosta de viver em grandes grupos.', 'Vida Terrestre'),
('Elefante', 'É o maior animal terrestre.', 'Ele tem uma grande tromba e orelhas largas.', 'O elefante é muito forte e inteligente.', 'Vida Terrestre'),
('Girafa', 'É um animal com pescoço muito longo.', 'Ela consegue alcançar as folhas mais altas das árvores.', 'Tem manchas no corpo da girafa.', 'Vida Terrestre'),
('Coelho', 'Tem orelhas grandes e fofas.', 'Adora comer cenouras e outros vegetais.', 'Ele é muito rápido e adora saltar.', 'Vida Terrestre'),
('Arara', 'É uma ave colorida e vibrante.', 'Ela vive em florestas tropicais.', 'Ela gosta de voar e cantar.', 'Vida Terrestre'),
('Abelha', 'Ela é pequena, mas muito importante.', 'Ela faz mel e ajuda na polinização das flores.', 'A abelha pode picar para se defender.', 'Vida Terrestre'),
('Borboleta', 'Ela tem asas coloridas e adora voar de flor em flor.', 'A borboleta começa como uma lagarta.', 'Ela é muito bonita e ajuda na polinização.', 'Vida Terrestre'),
('Avestruz', 'É a maior ave do mundo.', 'Ela não voa, mas corre muito rápido.', 'O avestruz tem um pescoço longo.', 'Vida Terrestre'),
('Macaco', 'É um animal que gosta de brincar.', 'O macaco adora bananas.', 'Ele pode andar nas árvores e é muito ágil.', 'Vida Terrestre'),
('Tigre', 'É um grande felino, muito forte e ágil.', 'O tigre tem listras no corpo.', 'Ele é um dos predadores mais respeitados.', 'Vida Terrestre'),
('Bicicleta', 'Usamos para andar pelas ruas e parques.', 'Tem duas rodas e pedais.', 'É um ótimo exercício para o corpo.', 'Cidades e Comunidades Sustentáveis'),
('Skate', 'Tem uma tábua com rodas e usamos para deslizar.', 'Ele pode ser usado para manobras e truques.', 'O skate é muito popular entre os jovens.', 'Cidades e Comunidades Sustentáveis'),
('Patins', 'Temos rodas nos pés e usamos para deslizar.', 'O patins é muito divertido, mas exige equilíbrio.', 'Podemos aprender a andar de patins em parques.', 'Cidades e Comunidades Sustentáveis'),
('Raquete', 'Usamos para jogar tênis ou ping-pong.', 'Ela tem uma rede esticada no meio.', 'Podemos usar para fazer pontos nos jogos.', 'Esporte e Atividades Físicas'),
('Bola', 'Usamos para jogar diversos esportes.', 'A bola é redonda e pode ser feita de vários materiais.', 'Ela pode ser de futebol, basquete ou vôlei.', 'Esporte e Atividades Físicas'),
('Corda', 'Usamos para pular ou amarrar coisas.', 'Ela pode ser longa ou curta.', 'É divertida para jogos de crianças.', 'Esporte e Atividades Físicas'),
('Cano', 'Usamos em sistemas de encanamento e irrigação.', 'Ele pode ser feito de plástico ou metal.', 'O cano transporta água ou gás.', 'Água Potável e Saneamento'),
('Papel', 'Usamos para escrever, desenhar ou embrulhar coisas.', 'Ele pode ser reciclado.', 'Existem papéis de diferentes cores e texturas.', 'Consumo e Produção Responsáveis'),
('Carro', 'Usamos para ir de um lugar a outro.', 'O carro tem quatro rodas e motor.', 'É importante usar o cinto de segurança.', 'Indústria, Inovação e Infraestrutura');



