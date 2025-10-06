**O que é o padrão de projeto?**
Um padrão de projeto é uma solução reutilizável e testada para problemas recorrentes de design de software. Ele não é um código pronto, mas sim uma forma de estruturar e organizar a lógica para resolver um determinado tipo de problema de maneira eficiente, clara e de fácil manutenção.

**O que é o anti-padrão de projeto?**
Um anti-padrão de projeto é o oposto de um padrão: é uma prática que, à primeira vista, parece resolver um problema, mas na prática gera mais dificuldades, aumentando a complexidade, o acoplamento e a dificuldade de manutenção do sistema. Em outras palavras, é uma “má prática disfarçada de solução”.

**O que é o padrão Strategy?**
O padrão Strategy é um padrão comportamental que permite definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis em tempo de execução. Ele elimina a necessidade de condicionais extensos (como vários `if/else`) e facilita a extensão do sistema, já que novos comportamentos podem ser adicionados sem modificar o código existente.

**O que é o anti-padrão Strategy?**
O anti-padrão Strategy acontece quando se tenta aplicar o Strategy, mas o contexto continua carregando a lógica de decisão com vários `if/else` ou `switch`, em vez de delegar totalmente o comportamento para as estratégias. Isso gera um “fake strategy”, no qual a intercambialidade não é real e cada nova variação exige modificar o código existente — exatamente o que o padrão deveria evitar.
