const depthFirstPrint = (graph, source) => {
    const stack = [source];



    while(stack.length > 0){

        //current node
        const current = stack.pop();
        console.log('stack bigger than ZERO' + '... Current node is'+ current);
        for(let neighbor of graph[current]){
            stack.push(neighbor);
        }
        
    };

    depthFirstPrint(graph, 'a');

    const depthFirstPrintRecursive = (graph, source) => {
        console.log(source);
        for(let neighbor of graph[source]){
            depthFirstPrintRecursive(graph,neighbor);
        }

        var graph = {
            a: ['c','b'],
            b: ['b'],
            c: ['e'],
            d: ['f'],
            e: [],
            f: []
        }



    };


}