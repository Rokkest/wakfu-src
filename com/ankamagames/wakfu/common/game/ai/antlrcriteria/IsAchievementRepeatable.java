package com.ankamagames.wakfu.common.game.ai.antlrcriteria;

import java.util.*;
import com.ankamagames.baseImpl.common.clientAndServer.game.achievements.*;
import com.ankamagames.framework.ai.criteria.antlrcriteria.*;

public class IsAchievementRepeatable extends FunctionCriterion
{
    private int m_achievementId;
    private static ArrayList<ParserType[]> signatures;
    
    @Override
    protected List<ParserType[]> getSignatures() {
        return IsAchievementRepeatable.signatures;
    }
    
    public IsAchievementRepeatable() {
        super();
    }
    
    public IsAchievementRepeatable(final ArrayList<ParserObject> args) {
        super();
        final short paramType = this.checkType(args);
        if (paramType == 0) {
            this.m_achievementId = (int)args.get(0).getLongValue(null, null, null, null);
        }
    }
    
    @Override
    public int getValidity(final Object criterionUser, final Object criterionTarget, final Object criterionContent, final Object criterionContext) {
        AchievementsContext achievementContext = null;
        if (criterionContext instanceof AchievementsContext) {
            achievementContext = (AchievementsContext)criterionContext;
        }
        else if (criterionUser instanceof AchievementsContextProvider) {
            achievementContext = ((AchievementsContextProvider)criterionUser).getAchievementsContext();
        }
        if (achievementContext == null) {
            throw new CriteriaExecutionException("Utilisation du crit\u00e8re IsAchievementRepeatable hors d'un contexte d'achievement");
        }
        if (achievementContext.hasAchievement(this.m_achievementId)) {
            return achievementContext.isAchievementRepeatable(this.m_achievementId) ? 0 : -1;
        }
        throw new CriteriaExecutionException("Utilisation du crit\u00e8re IsAchievementRepeatable sur un achievement d'id inexistant id=" + this.m_achievementId);
    }
    
    @Override
    public Enum getEnum() {
        return WakfuCriterionIds.IS_ACHIEVEMENT_REPEATABLE;
    }
    
    static {
        IsAchievementRepeatable.signatures = new ArrayList<ParserType[]>();
        final ParserType[] sig = { ParserType.NUMBER };
        IsAchievementRepeatable.signatures.add(sig);
    }
}
