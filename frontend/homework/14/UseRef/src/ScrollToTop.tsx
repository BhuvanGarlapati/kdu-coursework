import React, { useRef } from 'react';
 export const ScrollToTop: React.FC = () => {
    const containerRef = useRef<HTMLDivElement>(null);

    const scrollToTop = () => {
      if (containerRef.current) {
        containerRef.current.scrollTop = 0;
      }
    };
    return (
        <div ref={containerRef} style={{ height: '400px', overflowY: 'scroll' }}>
        {/* Your component content goes here */}
        <p>
        A car, or an automobile, is a motor vehicle with wheels. Most definitions of cars state that they run primarily on roads, seat one to eight people, have four wheels, and mainly transport people, not cargo.[1][2] French inventor Nicolas-Joseph Cugnot built the first steam-powered road vehicle in 1769, while French-born Swiss inventor François Isaac de Rivaz designed and constructed the first internal combustion-powered automobile in 1808.

The modern car—a practical, marketable automobile for everyday use—was invented in 1886, when German inventor Carl Benz patented his Benz Patent-Motorwagen. Commercial cars became widely available during the 20th century. One of the first cars affordable by the masses was the 1908 Model T, an American car manufactured by the Ford Motor Company. Cars were rapidly adopted in the US, where they replaced horse-drawn carriages.[3] In Europe and other parts of the world, demand for automobiles did not increase until after World War II.[4] The car is considered an essential part of the developed economy.

Cars have controls for driving, parking, passenger comfort, and a variety of lamps. Over the decades, additional features and controls have been added to vehicles, making them progressively more complex. These include rear-reversing cameras, air conditioning, navigation systems, and in-car entertainment. Most cars in use in the early 2020s are propelled by an internal combustion engine, fueled by the combustion of fossil fuels. Electric cars, which were invented early in the history of the car, became commercially available in the 2000s and are predicted to cost less to buy than petrol-driven cars before 2025.[5][6] The transition from fossil fuel-powered cars to electric cars features prominently in most climate change mitigation scenarios,[7] such as Project Drawdown's 100 actionable solutions for climate change.[8]

There are costs and benefits to car use. The costs to the individual include acquiring the vehicle, interest payments (if the car is financed), repairs and maintenance, fuel, depreciation, driving time, parking fees, taxes, and insurance.[9] The costs to society include maintaining roads, land use, road congestion, air pollution, noise pollution, public health, and disposing of the vehicle at the end of its life. Traffic collisions are the largest cause of injury-related deaths worldwide.[10] Personal benefits include on-demand transportation, mobility, independence, and convenience.[11] Societal benefits include economic benefits, such as job and wealth creation from the automotive industry, transportation provision, societal well-being from leisure and travel opportunities, and revenue generation from taxes. People's ability to move flexibly from place to place has far-reaching implications for the nature of societies.[12] There are around one billion cars in use worldwide. Car usage is increasing rapidly, especially in China, India, and other newly industrialized countries.[13]

Etymology
The English word car is believed to originate from Latin carrus/carrum "wheeled vehicle" or (via Old North French) Middle English carre "two-wheeled cart", both of which in turn derive from Gaulish karros "chariot".[14][15] It originally referred to any wheeled horse-drawn vehicle, such as a cart, carriage, or wagon.[16][17]

"Motor car", attested from 1895, is the usual formal term in British English.[2] "Autocar", a variant likewise attested from 1895 and literally meaning "self-propelled car", is now considered archaic.[18] "Horseless carriage" is attested from 1895.[19]

"Automobile", a classical compound derived from Ancient Greek autós (αὐτός) "self" and Latin mobilis "movable", entered English from French and was first adopted by the Automobile Club of Great Britain in 1897.[20] It fell out of favour in Britain and is now used chiefly in North America,[21] where the abbreviated form "auto" commonly appears as an adjective in compound formations like "auto industry" and "auto mechanic".[22][23]
        </p>

        {/* Scroll to Top button */}
        <button className='scroll-to-top-button' onClick={scrollToTop}>Scroll to Top</button>
      </div>
    );
  };
