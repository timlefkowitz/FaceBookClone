


kaboom({
    level:0,
    score:0,
    global:true,
    fullscreen: true,
    font: "sinko",
    // canvas: document.querySelector("#mycanvas"),
    background:[0,0,255],
    scale:1,
    debug: true,

    // clearColor:[1,1,1,0],
})



// Speeds
const MOVE_SPEED = 120
const SLICER_SPEED = 100
const SKELETOR_SPEED = 60


// TEXTURES // SPRITES

// loading root of textures
loadRoot('https://i.imgur.com/')

loadSprite('link-going-left', 'mB3usw7.png')
loadSprite('link-going-right', 'mB3usw7.png')
loadSprite('link-going-down', 'r377FIM.png')
loadSprite('link-going-up', 'UkV0we0.png')

loadSprite('leftWall', 'NnOz1Cj.png')
loadSprite('rightWall', '1DPJLAn.png')
loadSprite('topWall', 'Y51GAUW.png')
loadSprite('bottomWall', 'JL2gskl.png')

loadSprite('bottom-left-wall', '0AbS81C.png')
loadSprite('bottom-right-wall', 'jIpIcL2.png')
loadSprite('top-right-wall', 'E56MDPl.png')
loadSprite('top-left-wall', '6w5y9ua.png')

loadSprite('top-door','U9nre4n.png')
loadSprite('left-door','okdJNls.png')
loadSprite('fire-pot','I7xSp7w.png')
loadSprite('lanterns','wiSiY09.png')
loadSprite('slicer','c6JFi5Z.png')
loadSprite('skeletor','Ei1VnX8.png')
loadSprite('stairs','VghkL08.png')
loadSprite('bg','u4DVsx6.png')
loadSprite('kaboom','o9WizfI.png')


scene("game", ({level, score}) => {

    layers(['bg', 'obj', 'ui'], 'obj')

    const maps = [
        [
            'zccccccccx',
            'a        b',
            'a        b',
            '%    >   b',
            'a        b',
            'a        b',
            'a        b',
            'a        b',
            'a    >   b',
            'a        b',
            'a        b',
            'a        b',
            'a    {   b',
            'wdddd#dddy'
        ],
        [
            'zccccccccccx',
            'a          b',
            'a       *  b',
            'a   *      b',
            '{          {',
            'a          b',
            'a    }     b',
            'a          b',
            'wdddddd#dddy'
        ],
    ]

    const levelCfg = {
        width:48,
        height:48,
        'a': [sprite('leftWall'),solid(), 'wall'],
        'b': [sprite('rightWall'),solid(), 'wall'],
        'c': [sprite('topWall'),solid(), 'wall'],
        'd': [sprite('bottomWall'),solid(), 'wall'],

        'w': [sprite('bottom-left-wall'),solid(), 'wall'],
        'x': [sprite('top-right-wall'),solid(),'wall'],
        'y': [sprite('bottom-right-wall'),solid(), 'wall'],
        'z': [sprite('top-left-wall'),solid(), 'wall'],

        '%': [sprite('left-door'), solid(), 'door'],
        '#': [sprite('top-door'), 'next-level'],
        '^': [sprite('stairs'), 'next-level'],

        '*': [sprite('slicer'),{dir: -1}, 'slicer', 'dangerous'],
        '}': [sprite('skeletor'), 'dangerous'],
        '{': [sprite('lanterns'),solid()],
        '>': [sprite('fire-pot'),solid()],
    }
    addLevel(maps[level],levelCfg)


    // BACKGROUND
    // add(sprite('bg'), layer('bg'))

    const scoreLabel = add([
        text('0'),
        pos(400,450),
        layer('ui'),
        {
            value: score,
        },
        scale(2)
    ])


    add([text('Towers of Hanoi' +
        parseInt(level + 1)),
        pos(400,485),
        scale(2)])

    // player

    const player = add([
        sprite('link-going-right'),
        pos(5,190),
        {
            dir: vec2(1,0)
        }
    ])

    player.action(() => {
        player.resolve()
    })

    player.overlaps('next-level', () => {
        go("game", {
            level: (level + 1) % maps.length,
            score: scoreLabel.value,
        })
    })

    keyDown('left', () => {
        player.changeSprite('link-going-left')
        player.move(-MOVE_SPEED,0)
        player.dir = vec2(-1,0)
    })
    keyDown('right', () => {
        player.changeSprite('link-going-right')
        player.move(MOVE_SPEED,0)
        player.dir = vec2(1,0)
    })
    keyDown('up', () => {
        player.changeSprite('link-going-up')
        player.move(0, -MOVE_SPEED)
        player.dir = vec2(0,-1)
    })
    keyDown('down', () => {
        player.changeSprite('link-going-down')
        player.move(0, MOVE_SPEED)
        player.dir = vec2(0,1)
    })

    action('slicer', (s) => {
        s.move(s.dir * SLICER_SPEED, 0)
    })

    collides('slicer', 'wall', (s) => {
        s.dir = -s.dir
    })

    player.overlaps('dangerous', () =>{
        go('lose', {score:scoreLabel.value})
    })
})

scene('lose',({ score }) =>{
    add([text(score,32), origin('center'), pos(width()/2, height()/2)])
})

start("game", {level:0,score:0})