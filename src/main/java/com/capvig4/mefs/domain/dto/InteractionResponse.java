package com.capvig4.mefs.domain.dto;

import com.capvig4.mefs.domain.ActionItem;
import com.capvig4.mefs.domain.Feedback;
import com.capvig4.mefs.domain.Interaction;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InteractionResponse {
    List<Feedback> feedbacks;
    List<ActionItem> actionItems;
    Interaction interaction;
}
