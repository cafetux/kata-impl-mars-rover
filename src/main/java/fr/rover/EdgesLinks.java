package fr.rover;

import fr.rover.coordonnee.Coordonnee;

import java.util.HashMap;
import java.util.Optional;

/**
 * Created by fmaury on 17/08/16.
 */
public class EdgesLinks {
    private java.util.Map<Coordonnee, Coordonnee> links = new HashMap<>();

    /**
     * when interract with originLink, consider interract with destinationLink
     * @param originLink the edge who are after map limit
     * @param destinationLink the edge we really are
     */
    public void addLinkBetweenEdges(Coordonnee originLink,Coordonnee destinationLink){
        links.put(originLink,destinationLink);
    }

    public Optional<Coordonnee> getDestinationEdgeFrom(Coordonnee theoricPosition) {
        return Optional.ofNullable(links.get(theoricPosition));
    }
}
