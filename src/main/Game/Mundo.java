package Game;

import Area.AreaObservadora;
import Area.AreaEscura;
import Area.Area;
import Comportamentos.Abrivel;
import Comportamentos.Apagavel;
import Comportamentos.Comportamento;
import Comportamentos.Descartavel;
import Comportamentos.Destrutivel;
import Comportamentos.Examinavel;
import Comportamentos.ExaminavelADistancia;
import Comportamentos.Finalizavel;
import Comportamentos.Guardavel;
import Comportamentos.Legivel;
import Comportamentos.Luminoso;
import Comportamentos.Pegavel;
import Comportamentos.PortaAbrivel;
import Comportamentos.UsavelFixo;
import Comportamentos.UsavelUnico;
import java.util.ArrayList;

public class Mundo {

    private Comportamento apagavel, legivel, descartavel, examinavel,
            guardavel, luminoso, pegavel, examinavelAD;

    private static Mundo instancia = null;

    public static Mundo getInstancia() {
        if (instancia == null) {
            instancia = new Mundo();
        }
        return instancia;
    }

    public Mundo() {
        criarComportamentos();
        criarMundo();
    }

    private void criarMundo() {

        Item cartaCav = new Item("bilhete", "Olá, espero que você acorde logo. \nNosso navio afundou em uma tempestade, ninguém sobreviveu além de eu e você,\ndeixei uma lanterna dentro da caverna e fui procurar ajuda. \nRoth");
        cartaCav.addComportamento(pegavel);
        cartaCav.addComportamento(guardavel);
        cartaCav.addComportamento(descartavel);
        cartaCav.addComportamento(legivel);

        Item lanterna = new Item("lanterna");
        lanterna.addComportamento(pegavel);
        lanterna.addComportamento(guardavel);
        lanterna.addComportamento(luminoso);
        lanterna.addComportamento(descartavel);

        Item pergaminho = new Item("pergaminho", "Descobri o segredo desta ilha que nos mantêm presos aqui.\nDe alguma forma, a imperatriz Himiko ainda atua nessa ilha,\nprendendo as pessoas para formar um novo exército.\nTalvez encontrando o que restou dela, possa dar um fim nessa maldição. \nAs inscrições na parede falam que a luz e o sol mostrarão o caminho.");
        pergaminho.addComportamento(pegavel);
        pergaminho.addComportamento(guardavel);
        pergaminho.addComportamento(descartavel);
        pergaminho.addComportamento(legivel);

        Item cartaTri = new Item("carta", "Olá novamente, meus ferimentos estão cada vez mais graves e não posso mais continuar. \nAndei observando este lugar e percebi que há uma estação de rádio perto daqui.\nSeria um bom lugar para tentar pedir ajuda.\nDigam aos meus familiares que os amo.\nRoth");
        cartaTri.addComportamento(pegavel);
        cartaTri.addComportamento(guardavel);
        cartaTri.addComportamento(descartavel);
        cartaTri.addComportamento(legivel);

        Item equipEscalada = new Item("equipamento", "Um equipamento de escalada.");
        equipEscalada.addComportamento(pegavel);
        equipEscalada.addComportamento(guardavel);
        equipEscalada.addComportamento(descartavel);
        equipEscalada.addComportamento(examinavel);
        ArrayList<Item> arrayEquipEsc = new ArrayList<>();
        arrayEquipEsc.add(equipEscalada);

        ArrayList<Item> itensCxFerr = new ArrayList<>();

        ArrayList<Item> arrayMartelo = new ArrayList<>();

        Item martelo = new Item("martelo", "Um martelo comum");
        martelo.addComportamento(pegavel);
        martelo.addComportamento(examinavel);
        martelo.addComportamento(descartavel);
        martelo.addComportamento(guardavel);

        UsavelUnico usaSinal = new UsavelUnico("Após alguns minutos de espera, o avião aparece no céu. \nSurpreendentemente, uma grande tempestade se forma e vários raios atingem o avião... \nOuve-se palavras... \n\"Ninguém escapa!\" \nCom os motores em combustão, o inevitável acontece... \nO avião cai em uma outra região.");
        Item sinalizador = new Item("sinalizador");
        sinalizador.addComportamento(usaSinal);
        sinalizador.addComportamento(pegavel);
        sinalizador.addComportamento(descartavel);
        sinalizador.addComportamento(guardavel);
        sinalizador.addComportamento(descartavel);

        Item chavePorta = new Item("chave", "Uma chave com um chaveiro em formato de bomba de gasolina");
        chavePorta.addComportamento(pegavel);
        chavePorta.addComportamento(examinavel);
        chavePorta.addComportamento(guardavel);
        chavePorta.addComportamento(descartavel);
        ArrayList<Item> arrayChave = new ArrayList<>();
        arrayChave.add(chavePorta);

        PortaAbrivel pAbrivel = new PortaAbrivel(arrayChave);
        Item porta = new Item("porta", "Uma porta de ferro com uma fechadura.");
        porta.addComportamento(pAbrivel);
        porta.addComportamento(examinavelAD);
        ArrayList<Item> arrayPorta = new ArrayList<>();
        arrayPorta.add(porta);

        ArrayList<Item> itensPainel = new ArrayList<>();

        Item chaveCxFerr = new Item("chaveta", "Uma pequena chave com um chaveiro em formato de uma chave de boca");
        chaveCxFerr.addComportamento(pegavel);
        chaveCxFerr.addComportamento(examinavel);
        chaveCxFerr.addComportamento(guardavel);
        chaveCxFerr.addComportamento(descartavel);
        ArrayList<Item> arrayChaveCxFerr = new ArrayList<>();
        arrayChaveCxFerr.add(chaveCxFerr);

        itensCxFerr.add(martelo);
        itensCxFerr.add(sinalizador);
        itensCxFerr.add(chavePorta);
        Abrivel cxFerrAbrivel = new Abrivel(arrayChaveCxFerr, itensCxFerr);
        Item caixaFerr = new Item("caixa", "Uma caixa com uma desenho de uma chave de boca.");
        caixaFerr.addComportamento(examinavelAD);
        caixaFerr.addComportamento(cxFerrAbrivel);

        Item comunicador = new Item("comunicador");
        comunicador.addComportamento(new UsavelFixo(null, "Aqui é o vôo de resgate N1573B9. \nEstamos procurando por sobreviventes do naufrágio... \n...Que bom que conseguimos contato com você. \nTente exibir algum sinal de sua localização para que possamos lhe resgatar..."));

        itensPainel.add(chaveCxFerr);
        itensPainel.add(comunicador);
        Abrivel painelAbrivel = new Abrivel(null, itensPainel);
        Item painel = new Item("painel", "Um painel de comunicação.");
        painel.addComportamento(examinavelAD);
        painel.addComportamento(painelAbrivel);

        Item runa = new Item("runa", "Uma runa em formado de sol");
        runa.addComportamento(pegavel);
        runa.addComportamento(examinavel);
        runa.addComportamento(guardavel);
        runa.addComportamento(descartavel);
        ArrayList<Item> arrayRuna = new ArrayList<>();
        arrayRuna.add(runa);

        PortaAbrivel pAbrivel2 = new PortaAbrivel(arrayRuna);
        Item portal = new Item("portal", "Um portal com um sol desenhado e um pequeno encaixe, também em formato de sol.");
        portal.addComportamento(pAbrivel2);
        portal.addComportamento(examinavelAD);
        ArrayList<Item> arrayPortal = new ArrayList<>();
        arrayPortal.add(portal);

        ArrayList<Item> itensCaixaAviao = new ArrayList<>();
        itensCaixaAviao.add(equipEscalada);
        Abrivel cxAvAbrivel = new Abrivel(null, itensCaixaAviao);
        Item caixaAviao = new Item("caixa", "Uma caixa dentre os destroços do avião");
        caixaAviao.addComportamento(cxAvAbrivel);
        caixaAviao.addComportamento(examinavelAD);
        ArrayList<Item> itensAviao = new ArrayList<>();
        itensAviao.add(caixaAviao);

        ArrayList<Item> arrayGalao = new ArrayList<>();

        Item galao = new Item("galao", "Um galão de gasolina.");
        galao.addComportamento(pegavel);
        galao.addComportamento(examinavelAD);
        galao.addComportamento(descartavel);

        ArrayList<Item> itensTumba = new ArrayList<>();

        arrayMartelo.add(martelo);
        Destrutivel destColar = new Destrutivel(arrayMartelo, "Ao quebrar o colar, uma forte ventania parece sair de dentro dele.\nO corpo da tumba, antes em perfeito estado de conservação, começa a apodrecer. \nEm alguns segundos depois, a ventania cessa.");
        Item colar = new Item("colar", "Um colar, feito de jade e em formato de sol, no pescoço de uma mulher morta.");
        colar.addComportamento(destColar);
        colar.addComportamento(examinavelAD);

        Item corpo = new Item("corpo", "Um corpo de uma mulher morta.");
        corpo.addComportamento(examinavelAD);

        itensTumba.add(corpo);
        itensTumba.add(colar);

        Abrivel abreTumba = new Abrivel(null, itensTumba);
        Item tumba = new Item("tumba", "Uma tumba de pedra, com um sol estalhado.");
        tumba.addComportamento(examinavelAD);
        tumba.addComportamento(abreTumba);

        arrayGalao.add(galao);
        Finalizavel usaBarco = new Finalizavel(arrayGalao, colar, "O barco foi ligado e você segue em frente para escapar, \nmas uma forte tempestade se forma e as ondas te levam para a praia novamente", "Você liga o barco e segue em frente, com o tempo claro, você consegue partir em busca de socorro.\n FIM DE JOGO.");
        Item barco = new Item("barco");
        barco.addComportamento(usaBarco);

        //ÁREAS E ITENS ESCUROS
        AreaEscura cavEscura = new AreaEscura("Agora você consegue ver um bilhete.");
        AreaEscura tempEscuro = new AreaEscura("Agora muitos de sóis brilham na parede, um deles se destaca na multidão, parece ser uma runa brilhante.");

        cavEscura.addItemInvisivel(cartaCav);
        tempEscuro.addItemInvisivel(runa);

        //ÁREAS
        Area caverna = new Area("Caverna", "Você acordou com muita dor de cabeça, dentro de uma formação rochosa.", cavEscura);
        Area penhasco = new Area("Penhasco", "Agora você está na beira de um penhasco.,"
                + " \nVocê consegue ver algumas aves,"
                + " na água, cascos de aviões e navios lhe causam estranheza.");
        Area floresta = new Area("Floresta", "Agora você está num lugar rodeado de árvores, você vê alguns animais.");
        Area trilha = new Area("Trilha", "Você segue pela trilha...  e vê o corpo de Roth no chão, segurando uma carta.");
        Area estacaoGas = new Area("Estação de Gasolina", "Você está num pequeno posto de gasolina, há uma porta ao sul.");
        Area estacaoRadio = new Area("Estação de Rádio", "Você está numa estação de rádio antiga o suficiente para não funcionar mais... ");
        Area torreTrans = new Area("Torre de Transmissão", "Agora você está vendo uma enorme antena, com uma luz piscante no topo e um painel na base.");
        Area vilaAntiga = new Area("Vila Antiga", "Agora você está numa vilarejo de arquitetura nipônica.");
        Area palacio = new Area("Palácio Imperial", "Você entra num palácio feito de ouro, a sua frente há uma tumba");
        Area praia = new AreaObservadora("Praia", "Você está em uma praia, \nos esqueletos de navios e aviões vistos antes, agora estão mais perto.", sinalizador, "O avião de resgate caiu na praia e agora se une aos outros esqueletos, \nnão há sobreviventes. Dentre os destroços, uma caixa.", itensAviao);
        Area templo = new Area("Templo da Rainha do Sol", "Você entra num templo, você não consegue ver nada além de um esqueleto com um pergaminho.", tempEscuro);

        // ITENS DAS ÁREAS
        caverna.addItem(lanterna);
//        caverna.addItem(sinalizador);
//        caverna.addItem(martelo);
//        caverna.addItem(runa);
//        caverna.addItem(galao);
//        caverna.addItem(chavePorta);
//        caverna.addItem(equipEscalada);
        trilha.addItem(cartaTri);
        estacaoGas.addItem(galao);
        estacaoGas.addItem(porta);
        estacaoRadio.addItem(caixaFerr);
        torreTrans.addItem(painel);
        praia.addItem(barco);
        palacio.addItem(tumba);
        vilaAntiga.addItem(portal);
        templo.addItem(pergaminho);

        // SAÍDAS DAS ÁREAS
        Saida saidaCavernaN = new Saida("norte", penhasco);
        caverna.addSaida(saidaCavernaN);

        ArrayList<Saida> saidasPenhasco = new ArrayList<>();
        Saida saidaPenhasco2N = new Saida("norte", floresta);
        Saida saidaPenhasco2S = new Saida("sul", caverna);
        saidasPenhasco.add(saidaPenhasco2N);
        saidasPenhasco.add(saidaPenhasco2S);
        penhasco.addSaida(saidasPenhasco);

        ArrayList<Saida> saidasFloresta = new ArrayList<>();
        Saida saidaFlorestaN = new Saida("norte", trilha);
        Saida saidaFlorestaS = new Saida("sul", penhasco);
        Saida saidaFlorestaL = new Saida("leste", templo, arrayEquipEsc, null, "Você precisa de um equipamento de escalada ir nessa direção");
        Saida saidaFlorestaO = new Saida("oeste", estacaoGas);
        saidasFloresta.add(saidaFlorestaN);
        saidasFloresta.add(saidaFlorestaS);
        saidasFloresta.add(saidaFlorestaL);
        saidasFloresta.add(saidaFlorestaO);
        floresta.addSaida(saidasFloresta);

        ArrayList<Saida> saidasEstacaoGas = new ArrayList<>();
        Saida saidaEstacaoGasS = new Saida("sul", vilaAntiga, null, arrayPorta,"");
        Saida saidaEstacaoGasL = new Saida("leste", floresta);
        saidasEstacaoGas.add(saidaEstacaoGasS);
        saidasEstacaoGas.add(saidaEstacaoGasL);
        estacaoGas.addSaida(saidasEstacaoGas);

        ArrayList<Saida> saidasVilaAntiga = new ArrayList<>();
        Saida saidaVilaAntigaN = new Saida("norte", estacaoGas);
        Saida saidaVilaAntigaO = new Saida("oeste", palacio, null, arrayPortal,"");
        Saida saidaVilaAntigaL = new Saida("leste", praia);
        saidasVilaAntiga.add(saidaVilaAntigaN);
        saidasVilaAntiga.add(saidaVilaAntigaO);
        saidasVilaAntiga.add(saidaVilaAntigaL);
        vilaAntiga.addSaida(saidasVilaAntiga);

        Saida saidaPalacioL = new Saida("leste", vilaAntiga);
        palacio.addSaida(saidaPalacioL);

        ArrayList<Saida> saidasTrilha = new ArrayList<>();
        Saida saidaTrilhaN = new Saida("norte", estacaoRadio);
        Saida saidaTrilhaS = new Saida("sul", floresta);
        saidasTrilha.add(saidaTrilhaN);
        saidasTrilha.add(saidaTrilhaS);
        trilha.addSaida(saidasTrilha);

        ArrayList<Saida> saidasEstacaoRadio = new ArrayList<>();
        Saida saidaEstacaoRadioS = new Saida("sul", trilha);
        Saida saidaEstacaoRadioL = new Saida("leste", torreTrans);
        saidasEstacaoRadio.add(saidaEstacaoRadioS);
        saidasEstacaoRadio.add(saidaEstacaoRadioL);
        estacaoRadio.addSaida(saidasEstacaoRadio);

        Saida saidaTorreO = new Saida("oeste", estacaoRadio);
        torreTrans.addSaida(saidaTorreO);

        Saida praiaO = new Saida("oeste", vilaAntiga);
        praia.addSaida(praiaO);

        Saida temploO = new Saida("oeste", floresta);
        templo.addSaida(temploO);

        Jogador.getInstancia().setAreaAtual(caverna);

    }

    private void criarComportamentos() {
        apagavel = new Apagavel();
        descartavel = new Descartavel();
        examinavel = new Examinavel();
        examinavelAD = new ExaminavelADistancia();
        guardavel = new Guardavel();
        luminoso = new Luminoso();
        pegavel = new Pegavel();
        legivel = new Legivel();
    }
}
